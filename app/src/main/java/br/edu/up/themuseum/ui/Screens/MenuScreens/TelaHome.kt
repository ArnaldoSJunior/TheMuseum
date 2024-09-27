package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.DrawerContent
import br.edu.up.themuseum.Rotas
import br.edu.up.themuseum.ui.Screens.Util.TopBarMinima

@Composable
 fun HomeMenu( navController: NavController) {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent() }
    ) {


        Scaffold(
            topBar = { TopBarMinima(drawerState) },
            content = { paddingValues ->
                ConteudoPrincipal(
                    navController = navController,
                    paddingValues
                )
            }
        )
    }
}

@Composable
private fun ConteudoPrincipal(navController: NavController, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Bottom
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaIngresso) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Ingresso",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Ingressos",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaProgramacao) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Programação",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Programação",
                            color = Color.Black,
                            fontSize = 12.sp,
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaCardapio) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Cardápio",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Cardápio",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaComanda) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Comanda",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Comanda",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaAniversario) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Aniversário",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Aniversário",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaGaleria) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Galeria",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Galeria",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaChapelaria) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Chapelaria",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Chapelaria",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaAchados) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Achados",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Achados & Perdidos",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White)
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaFaleConosco) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Fale Conosco",
                            tint = Color.Black,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Fale Conosco",
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

