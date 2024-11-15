package br.edu.up.themuseum.ui.Screens.Util

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.Rotas
import br.edu.up.themuseum.ui.theme.Caqui
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.PretoMostarda
import br.edu.up.themuseum.ui.theme.Verde


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarTelas(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Rotas.HomeMenu)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Verde,
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        title = {
            Text(
                text = "THEMuseum",
                fontSize = 40.sp,
                color = Caqui,
                fontFamily = ModakFont,
                fontWeight = FontWeight(600)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(PretoMostarda)
    )
}
