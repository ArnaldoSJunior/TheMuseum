package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel

@Composable
fun TelaPedidos(
                PedidoId: Int? = null,
                navController: NavController,
                viewModel: PedidosViewModel ) {
    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                listarPedidos(viewModel, navController)

            }
        }
    )
}

@Composable
fun listarPedidos(
    viewModel : PedidosViewModel,
    navController: NavController
){

    val courotineScope = rememberCoroutineScope()


    val pedidos by viewModel.pedidos.collectAsState()


    Text(text = "Pedidos",
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold)
    Spacer(modifier = Modifier.height(10.dp))
    if (pedidos.isEmpty()) {
        Text(text = "Nenhum pedido encontrado", fontSize = 20.sp)
    } else {
        for (pedido in pedidos) {
            Row{
                Text(
                    text = "Nome: ${pedido.nome}\nCPF: ${pedido.cpf}\nTelefone: ${pedido.tel}",
                    fontSize = 20.sp
                )
                Button(onClick ={
                    navController.navigate("pedido/${pedido.id}")
                } ) {
                    Text(text = "Editar", fontSize = 25.sp)
                }
                Button( onClick = {
                    viewModel.excluir(pedido)
                }) { Text(text = "Excluir", fontSize = 25.sp)}


            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
