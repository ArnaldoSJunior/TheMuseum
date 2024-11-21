package br.edu.up.themuseum.data.Repository

import br.edu.up.themuseum.data.Models.Pedidos
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await


class RemoteRepository(): IRepository {

    var db = FirebaseFirestore.getInstance()
    var pedidosCollection = db.collection("pedidos")


    override fun listarPedidos(): Flow<List<Pedidos>> = callbackFlow {

        val listener = pedidosCollection.addSnapshotListener { values, error ->
            if(error != null){
                close(error)
                return@addSnapshotListener
            }
            if(values != null){
                val pedidos = values.documents.mapNotNull { values ->
                    values.toObject(Pedidos::class.java)
                }
                trySend(pedidos).isSuccess
            }
        }
        awaitClose{listener.remove()}
    }


    suspend fun getId(): Int {
        val values = pedidosCollection.get().await()
        val maxId = values.documents.mapNotNull {
            it.getLong("id")?.toInt()
        }.maxOrNull() ?: 0
        return maxId + 1
    }

    override suspend fun gravarPedido(pedidos: Pedidos) {
        val document: DocumentReference
        if(pedidos.id == null){
            pedidos.id = getId()
            document = pedidosCollection.document(pedidos.id.toString())
        }else{
            document = pedidosCollection.document(pedidos.id.toString())
        }
        document.set(pedidos).await()
    }

    override suspend fun buscarPedidoPorId(idx: Int): Pedidos? {
        val values = pedidosCollection.document(idx.toString()).get().await()
        return values.toObject(Pedidos::class.java)
    }


    override suspend fun excluirPedido(pedidos: Pedidos) {
       pedidosCollection.document(pedidos.id.toString()).delete().await()
    }







}