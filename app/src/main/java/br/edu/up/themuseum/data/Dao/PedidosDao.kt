package br.edu.up.themuseum.data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import br.edu.up.themuseum.data.Models.Pedidos


@Dao
interface PedidosDao{

    @Query("select * from Pedidos")
    suspend fun listarPedidos(): List<Pedidos>

    @Query("select * from pedidos where id = :idx")
    suspend fun buscarPedidoPorId(idx: Int): Pedidos

    @Upsert
    suspend fun gravarPedido(pedido: Pedidos)

    @Delete
    suspend fun excluirPedido(pedido: Pedidos)
}
