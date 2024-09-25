package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas


@Composable
fun TelaIngresso(navController: NavController) {
    Scaffold(
        topBar = { TopBarTelas(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "Ingressos", fontSize = 30.sp)
            }
        }
    )
}