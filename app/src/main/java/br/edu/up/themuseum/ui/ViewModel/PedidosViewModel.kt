package br.edu.up.themuseum.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.up.themuseum.data.Dao.PedidosDao
import br.edu.up.themuseum.data.Models.Pedidos
import br.edu.up.themuseum.data.Repository.IRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.collectLatest

class PedidosViewModel(
    private val repository: IRepository
) : ViewModel(){

    private val _pedidos = MutableStateFlow<List<Pedidos>>(emptyList())
    val pedidos: StateFlow<List<Pedidos>> get () = _pedidos

    init {
        viewModelScope.launch {
            repository.listarPedidos().collectLatest { listaDePedidos ->
                _pedidos.value = listaDePedidos

            }
        }

    }

    fun excluir(pedidos: Pedidos){
        viewModelScope.launch {
            repository.excluirPedido(pedidos)
        }
    }


    suspend fun buscarPedidoPorId(pedidoId: Int): Pedidos?{
        return withContext(Dispatchers.IO){
            repository.buscarPedidoPorId(pedidoId)
        }
    }

    fun gravar(pedidos: Pedidos){
        viewModelScope.launch{
            repository.gravarPedido(pedidos)
        }
    }





}



