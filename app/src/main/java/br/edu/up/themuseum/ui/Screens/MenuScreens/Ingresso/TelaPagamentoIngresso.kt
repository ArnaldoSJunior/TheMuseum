package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas

@Composable
fun TelaPagamentoIngresso(navController: NavController){

    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                androidx.compose.material3.Text(text = "Pagamento", fontSize = 30.sp)
            }
        }

    )

}