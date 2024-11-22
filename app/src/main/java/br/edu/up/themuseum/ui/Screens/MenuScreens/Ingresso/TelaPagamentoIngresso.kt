package br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.BottomBar
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.theme.Cinza
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.VerdeMenta

@Composable
fun TelaPagamentoIngresso(navController: NavController){

    Scaffold(
        topBar = { TopBarTelas(navController) },
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.fillMaxSize().padding(paddingValues).background(Cinza)) {
                Text(text = "Pagamento",fontSize = 30.sp, fontFamily = ModakFont,modifier = Modifier.padding(start = 16.dp),
                    color = VerdeMenta)
            }
        }

    )

}