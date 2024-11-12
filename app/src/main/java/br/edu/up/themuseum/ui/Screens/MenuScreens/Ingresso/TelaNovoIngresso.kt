package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.Rotas
import br.edu.up.themuseum.data.Models.Pedidos
import br.edu.up.themuseum.data.abrirBancoDeDados
import kotlinx.coroutines.launch



@Composable
fun NovosPedidos(navController: NavController, onCancelar: () -> Unit){

    val context = LocalContext.current
    val db = abrirBancoDeDados(context)
    var courotineScope = rememberCoroutineScope()

    var pedidos by remember { mutableStateOf(listOf<Pedidos>()) }
    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }

    LaunchedEffect(Unit){
        courotineScope.launch {
            if(db.PedidosDao().listarPedidos().isEmpty()){
                db.PedidosDao().gravarPedido(
                    Pedidos(nome="Arnaldo", cpf = "08529100964", tel = "99650232")
                )
            }
            pedidos = db.PedidosDao().listarPedidos()

        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(13.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp), // Bordas arredondadas
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5) // Cor de fundo do Card
        )
    ) {

        Column(
            modifier = Modifier.padding(
                top = 80.dp,
                start = 20.dp,
                end = 10.dp,
                bottom = 20.dp
            )
        ) {
            Text(
                text = "Novo Pedido",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },
                label = { Text("CPF") }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = tel,
                onValueChange = { tel = it },
                label = { Text("Telefone") }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {

                courotineScope.launch {
                    val novoPedido = Pedidos(
                        nome = nome,
                        cpf = cpf,
                        tel = tel
                    )
                    db.PedidosDao().gravarPedido(novoPedido)
                    pedidos = db.PedidosDao().listarPedidos()
                    navController.navigate(Rotas.TELA_PEDIDO)
                }
            }) {
                Text(text = "Salvar", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(30.dp))


           
            Button(onClick = onCancelar) {
                Text("Cancelar")
            }

        }

    }

}