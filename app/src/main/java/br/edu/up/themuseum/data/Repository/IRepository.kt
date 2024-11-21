package br.edu.up.themuseum.data.Repository

import br.edu.up.themuseum.data.Models.Pedidos
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun listarPedidos(): Flow<List<Pedidos>>
    suspend fun buscarPedidoPorId(idx: Int): Pedidos?
    suspend fun gravarPedido(pedidos: Pedidos)
    suspend fun excluirPedido(pedidos: Pedidos)

}