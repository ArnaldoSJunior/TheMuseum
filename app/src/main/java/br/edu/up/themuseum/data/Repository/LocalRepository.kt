package br.edu.up.themuseum.data.Repository

import br.edu.up.themuseum.data.Dao.PedidosDao
import br.edu.up.themuseum.data.Models.Pedidos
import kotlinx.coroutines.flow.Flow

class LocalRepository(
    private val dao : PedidosDao
):IRepository {

    override fun listarPedidos(): Flow<List<Pedidos>> {
        return dao.listarPedidos()
    }

    override suspend fun buscarPedidoPorId(idx: Int): Pedidos {
        return dao.buscarPedidoPorId(idx)
    }

    override suspend fun gravarPedido(pedidos: Pedidos) {
        dao.gravarPedido(pedidos)
    }

    override suspend fun excluirPedido(pedidos: Pedidos) {
        dao.excluirPedido(pedidos)
    }
}