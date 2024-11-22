package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.data.Models.Pedidos
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel
import br.edu.up.themuseum.ui.theme.Cinza
import br.edu.up.themuseum.ui.theme.Laranja
import br.edu.up.themuseum.ui.theme.PretoMostarda
import br.edu.up.themuseum.ui.theme.VerdeMenta
import kotlinx.coroutines.launch

@Composable
fun IncluirEditarPedidoScreen(
    PedidoId: Int? = null,
    viewModel: PedidosViewModel,
    navController: NavController,
    onCancelar: () -> Unit
){

    var coroutineScope = rememberCoroutineScope()

    var nome by remember { mutableStateOf("")}
    var cpf by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }

    var pedido: Pedidos? by remember { mutableStateOf(null) }
    var label = if (PedidoId == null) "Novo Pedido" else "Editar Pedido"

    LaunchedEffect(PedidoId) {
        coroutineScope.launch {
            if(PedidoId != null){
                pedido = viewModel.buscarPedidoPorId(PedidoId)
                pedido?.let{
                    nome = it.nome
                    cpf = it.cpf
                    tel = it.tel
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cinza)
            .padding(16.dp) ){
    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(13.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = VerdeMenta)
    ) {  Column(
        modifier = Modifier.padding(
            top =  90.dp,
            start = 30.dp,
            end = 30.dp,
            bottom = 30.dp
        )
    ) {
        Text(
            text = label,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = tel,
            onValueChange = { tel = it }
        )
        Button(onClick = {

            coroutineScope.launch {
                val pedidoSalvar = Pedidos(
                    id = PedidoId,
                    nome = nome,
                    cpf = cpf,
                    tel = tel
                )
                viewModel.gravar(pedidoSalvar)
                navController.popBackStack()

            }
        }
           , colors = ButtonDefaults.buttonColors(
                containerColor = Laranja,
                contentColor = PretoMostarda
            )) {
            Text(text = "Salvar", fontSize = 30.sp)
        }
        Button(onClick = onCancelar,
            colors = ButtonDefaults.buttonColors(
                containerColor = Laranja,
                contentColor = PretoMostarda
            )) {
            Text("Cancelar")
        }

    }
    }
}


}