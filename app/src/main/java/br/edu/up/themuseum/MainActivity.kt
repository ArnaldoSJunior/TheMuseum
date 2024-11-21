package br.edu.up.themuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.up.themuseum.data.DataBase.PedidosDataBase.Companion.abrirBancoDeDados
import br.edu.up.themuseum.data.Repository.LocalRepository
import br.edu.up.themuseum.data.Repository.RemoteRepository


import br.edu.up.themuseum.ui.TheMuseumApp
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val isLocal = false

        val db = abrirBancoDeDados(this)
        val localRepository = LocalRepository(db.PedidosDao())
        val remoteRepository = RemoteRepository()

        val viewModel: PedidosViewModel
        if (isLocal){
            viewModel = PedidosViewModel(localRepository)
        } else {
            viewModel = PedidosViewModel(remoteRepository)
        }
        setContent {
            TheMuseumApp(viewModel)


        }
    }
}