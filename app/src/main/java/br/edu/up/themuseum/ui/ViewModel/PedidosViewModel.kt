package br.edu.up.themuseum.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.themuseum.data.Dao.PedidosDao
import br.edu.up.themuseum.data.Models.Pedidos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.collectLatest

class PedidosViewModel(
    private val dao : PedidosDao
) : ViewModel(){

    fun excluir(pedido: Pedidos){
        viewModelScope.launch {
            dao.excluirPedido(pedido)
        }
    }

    fun gravar(pedido: Pedidos){
        viewModelScope.launch{
            dao.gravarPedido(pedido)
        }
    }

    suspend fun buscarPedidoPorId(PedidoId: Int): Pedidos?{
        return withContext(Dispatchers.IO){
            dao.buscarPedidoPorId(PedidoId)
        }
    }

    private val _pedidos = MutableStateFlow<List<Pedidos>>(emptyList())
    val pedidos: StateFlow<List<Pedidos>> get () = _pedidos

    init {
        viewModelScope.launch {
            dao.listarPedidos().collectLatest { listaDePedidos ->
                _pedidos.value = listaDePedidos

            }
        }

    }




}







