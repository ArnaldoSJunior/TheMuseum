package br.edu.up.themuseum.data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import br.edu.up.themuseum.data.Models.Pedidos
import kotlinx.coroutines.flow.Flow


@Dao
interface PedidosDao{

    @Query("select * from Pedidos")
    fun listarPedidos(): Flow<List<Pedidos>>

    @Query("select * from pedidos where id = :idx")
    suspend fun buscarPedidoPorId(idx: Int): Pedidos

    @Upsert
    suspend fun gravarPedido(pedido: Pedidos)

    @Delete
    suspend fun excluirPedido(pedido: Pedidos)
}
