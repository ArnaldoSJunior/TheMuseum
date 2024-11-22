package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel
import br.edu.up.themuseum.ui.theme.Caqui
import br.edu.up.themuseum.ui.theme.Cinza
import br.edu.up.themuseum.ui.theme.Laranja
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.VerdeMenta
import br.edu.up.themuseum.ui.theme.VerdeMusgo

@Composable
fun TelaPedidos(
                PedidoId: Int? = null,
                navController: NavController,
                viewModel: PedidosViewModel ) {
    Scaffold(
        topBar = { TopBarTelas(navController) },

        bottomBar = {
            BottomBar(navController)
          },

        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).background(Cinza).fillMaxSize())
                {
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


    Text(text = "Pedidos",fontSize = 30.sp, fontFamily = ModakFont,modifier = Modifier.padding(start = 16.dp),
        color = VerdeMenta)
    Spacer(modifier = Modifier.height(10.dp))
    if (pedidos.isEmpty()) {
        Text(text = "Nenhum pedido encontrado!", fontSize = 20.sp, fontFamily = ModakFont,modifier = Modifier.padding(start = 16.dp))
    } else {
        for (pedido in pedidos) {
          Card( modifier = Modifier
              .fillMaxWidth()
              .height(250.dp)
              .padding(16.dp),
              colors = CardDefaults.cardColors(
                  containerColor = VerdeMenta
              ),
              elevation = CardDefaults.elevatedCardElevation(8.dp)  ) {
              Column { Text(text = "Ingresso", fontSize = 20.sp, fontFamily = ModakFont,modifier = Modifier.padding(start = 16.dp)) }
              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(16.dp)
              ){

              Text(
                  text = "Nome: ${pedido.nome}\nCPF: ${pedido.cpf}\nTelefone: ${pedido.tel}",
                  fontSize = 20.sp,
                  modifier = Modifier.padding(start = 16.dp)
              )
              IconButton(onClick ={
                  navController.navigate("pedido/${pedido.id}")
              } ) {
                  Icon(
                      imageVector = Icons.Default.Edit,
                      contentDescription = "Editar",
                      tint = Color.Black,
                      modifier = Modifier.size(22.dp)
                  )
              }
              IconButton( onClick = {
                  viewModel.excluir(pedido)
              }) {  Icon(
                  imageVector = Icons.Default.Delete,
                  contentDescription = "Excluir",
                  tint = Color.Black,
                  modifier = Modifier.size(22.dp)
              )}

          }
              Button(
                      onClick = {
                          navController.navigate("pagamento")
                      },
              modifier = Modifier
                  .padding(start = 200.dp)
                  .width(200.dp)
                  .height(100.dp)
                  .padding(16.dp),
                  colors = ButtonDefaults.buttonColors(
                      containerColor = Laranja,
                      contentColor = VerdeMusgo
                  )
              ) {
              Text(text = "Finalizar Comprar", fontSize = 12.sp,)
          }

          }

            Spacer(modifier = Modifier.height(10.dp))





        }
    }
}
