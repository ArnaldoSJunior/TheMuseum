package br.edu.up.themuseum

import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.edu.up.themuseum.Rotas
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaAchados
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaAniversario
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaCardapio
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaChapelaria
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaComanda
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaFaleConosco
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaGaleria
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaIngresso
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaProgramacao
import br.edu.up.themuseum.ui.Screens.Util.TopBarMinima
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import kotlinx.coroutines.launch


object Rotas {
    const val HomeMenu = "Home"
    const val TelaIngresso = "tela_ingresso"
    const val TelaProgramacao = "tela_programacao"
    const val TelaCardapio = "tela_cardapio"
    const val TelaComanda = "tela_comanda"
    const val TelaAniversario = "tela_aniversario"
    const val TelaGaleria = "tela_galeria"
    const val TelaChapelaria = "tela_chapelaria"
    const val TelaAchados = "tela_achados"
    const val TelaFaleConosco = "tela_fale_conosco"
}


@Preview(
    device = Devices.PIXEL
)

@Composable
fun TheMuseumApp() {
    val navController = rememberNavController()

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {DrawerContent()}
    ) {
        Scaffold(
            topBar = { TopBarMinima(drawerState) },
            content = { paddingValues ->  NavHost(
                navController = navController,
                startDestination = Rotas.HomeMenu,
                Modifier.padding(paddingValues)
            ) {
                composable(Rotas.HomeMenu) { HomeMenu(paddingValues, navController) }
                composable(Rotas.TelaIngresso) { TelaIngresso(navController)}
                composable(Rotas.TelaProgramacao) { TelaProgramacao(navController)}
                composable(Rotas.TelaCardapio) { TelaCardapio(navController) }
                composable(Rotas.TelaComanda) { TelaComanda(navController) }
                composable(Rotas.TelaAniversario) { TelaAniversario(navController) }
                composable(Rotas.TelaGaleria) { TelaGaleria(navController) }
                composable(Rotas.TelaChapelaria) { TelaChapelaria(navController) }
                composable(Rotas.TelaAchados) { TelaAchados(navController) }
                composable(Rotas.TelaFaleConosco) { TelaFaleConosco(navController) }}
            }
        )
    }
}

@Composable
private fun HomeMenu(paddingValues: PaddingValues, navController: NavController) {

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
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = { navController.navigate(Rotas.TelaIngresso)},
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaProgramacao)},
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaCardapio)},
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
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaComanda)},
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaAniversario)},
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaGaleria) },
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

        // Linha final
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterHorizontally)
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaChapelaria)},
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaAchados) },
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

            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White)) {
                IconButton(
                    onClick = {navController.navigate(Rotas.TelaFaleConosco)},
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


@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .width(300.dp)
            .background(Color.White)
            .padding(30.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(
                painterResource(id= R.drawable.avatar),
                contentDescription = "Imagem de perfil",
                modifier = Modifier.size(80.dp))
            Text(text = "Perfil", fontSize = 30.sp)
        }

        Text(text = "Logout", fontSize = 20.sp)

    }
}

