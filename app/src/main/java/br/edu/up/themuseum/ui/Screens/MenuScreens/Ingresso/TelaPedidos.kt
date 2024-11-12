package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.data.Models.Pedidos
import br.edu.up.themuseum.data.abrirBancoDeDados
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.theme.VerdeMostarda
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun TelaPedidos(navController: NavController) {
    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                listarPedidos()
            }
        }
    )
}

@Composable
fun listarPedidos(){


    val context = LocalContext.current
    val db = abrirBancoDeDados(context)
    val courotineScope = rememberCoroutineScope()

    var pedidos by remember { mutableStateOf(listOf<Pedidos>()) }

    LaunchedEffect(Unit) {
        courotineScope.launch {
            pedidos = db.PedidosDao().listarPedidos()
        }
    }

    Text(text = "Pedidos",
        fontSize = 30.sp,
        fontWeight = FontWeight.ExtraBold)
    Spacer(modifier = Modifier.height(10.dp))
    if (pedidos.isEmpty()) {
        Text(text = "Nenhum pedido encontrado", fontSize = 20.sp)
    } else {
        for (pedido in pedidos) {
            Text(
                text = "Nome: ${pedido.nome}\nCPF: ${pedido.cpf}\nTelefone: ${pedido.tel}",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
