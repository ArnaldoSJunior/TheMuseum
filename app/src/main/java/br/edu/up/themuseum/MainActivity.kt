package br.edu.up.themuseum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.edu.up.themuseum.data.Dao.PedidosDataBase.Companion.abrirBancoDeDados


import br.edu.up.themuseum.ui.TheMuseumApp
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = abrirBancoDeDados(this)
        val viewModel = PedidosViewModel(db.PedidosDao())
        setContent {
            TheMuseumApp(viewModel)


        }
    }
}