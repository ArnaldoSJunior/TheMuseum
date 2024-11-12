package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas

@Composable
fun TelaIngresso( navController: NavController) {

    val currentScreen = remember { mutableStateOf("TelaIngresso") }
    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = {BottomBar(navController)},
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                CardComFormulario(navController,currentScreen)
            }
        }
    )

}


@Composable
fun CardComFormulario(navController: NavController, currentScreen: MutableState<String>) {
    var exibirFormulario by remember { mutableStateOf(false) }

    // Card Clicável
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { exibirFormulario = true },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Sábado", fontSize = MaterialTheme.typography.bodyLarge.fontSize)
        }
    }

    // Formulário exibido ao clicar no Card
    if (exibirFormulario) {
        NovosPedidos(navController = navController, onCancelar = { exibirFormulario = false })
    }
}








