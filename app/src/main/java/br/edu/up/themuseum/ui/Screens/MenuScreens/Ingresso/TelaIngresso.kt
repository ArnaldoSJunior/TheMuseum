package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import br.edu.up.themuseum.data.Dao.PedidosDao
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.ViewModel.PedidosViewModel
import br.edu.up.themuseum.ui.theme.Cinza
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.Verde

@Composable
fun TelaIngresso(
    viewModel: PedidosViewModel,
    navController: NavController) {

    val currentScreen = remember { mutableStateOf("TelaIngresso") }
    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = {BottomBar(navController)},
        content = { paddingValues ->
            Column(modifier = Modifier.fillMaxSize().padding(paddingValues).background(Cinza)) {
                Text(text = "Ingressos",fontSize = 30.sp, fontFamily = ModakFont,modifier = Modifier.padding(start = 16.dp))
                CardComFormulario(viewModel,navController,currentScreen)
            }
        }
    )

}


@Composable
fun CardComFormulario(viewModel: PedidosViewModel,navController: NavController, currentScreen: MutableState<String>) {
    var exibirFormulario by remember { mutableStateOf(false) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { exibirFormulario = true },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Verde
        )
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Text(text = "Festa", fontSize = 28.sp, fontFamily = ModakFont)
        }
    }


    if (exibirFormulario) {
        NovosPedidos( navController = navController, viewModel = viewModel ,  onCancelar = { exibirFormulario = false })
    }
}








