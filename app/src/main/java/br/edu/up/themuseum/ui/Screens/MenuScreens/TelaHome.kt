package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.R

import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.Screens.Util.TopBarMinima
import br.edu.up.themuseum.ui.theme.ModakFont
import br.edu.up.themuseum.ui.theme.PretoMostarda
import br.edu.up.themuseum.ui.theme.VerdeMenta
import br.edu.up.themuseum.ui.theme.VerdeMostarda

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
                .weight(1f)
                .background(Color(0xFF7B8373)),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.Bottom
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaIngresso) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.bilhetes),
                            contentDescription = "ingressos",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Ingressos",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 18.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaProgramacao) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.programacao),
                            contentDescription = "programacao",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Programação",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 13.sp,
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaCardapio) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.cardapios),
                            contentDescription = "cardapio",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Cardápio",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF7B8373)),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaComanda) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.comanda),
                            contentDescription = "comanda",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Comanda",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaAniversario) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.niver),
                            contentDescription = "aniversario",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Aniversário",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaGaleria) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.galeria),
                            contentDescription = "galeria",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Galeria",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(0xFF7B8373)),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaChapelaria) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.chapelaria),
                            contentDescription = "chapelaria",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Chapelaria",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaAchados) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.achadoseperdidos),
                            contentDescription = "achados e perdidos",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Achados & Perdidos",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF7B8373))
            ) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaFaleConosco) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.falando),
                            contentDescription = "fale conosco",
                            modifier = Modifier.size(50.dp) ,
                            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(VerdeMenta)

                        )
                        Text(
                            text = "Fale Conosco",
                            fontFamily = ModakFont,
                            color = VerdeMostarda,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color(0x77CEC8C8))
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Perfil", fontSize = 30.sp)
        }

        Text(text = "Logout", fontSize = 20.sp)

    }
}