package br.edu.up.themuseum.ui.Screens.Util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.R
import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.theme.Caqui
import br.edu.up.themuseum.ui.theme.Laranja
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.PretoMostarda
import br.edu.up.themuseum.ui.theme.Verde
import br.edu.up.themuseum.ui.theme.VerdeMostarda


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopBarTelas(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
    )
    {

        Image(
            painter = painterResource(id = R.drawable.fundo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )




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
                fontFamily = ModakFont,
                color = Laranja,
                style = TextStyle(
                    shadow = Shadow(
                        color = PretoMostarda,
                        offset = Offset(2f, 2f),
                        blurRadius = 2f)
            ))
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = androidx.compose.ui.graphics.Color.Transparent)
    )
}}
