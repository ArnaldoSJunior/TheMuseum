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
import br.edu.up.themuseum.Rotas.HomeMenu
import br.edu.up.themuseum.ui.Screens.MenuScreens.HomeMenu
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


    NavHost(
        navController = navController,
        startDestination = Rotas.HomeMenu

    ) {
        composable(Rotas.HomeMenu) { HomeMenu(navController) }
        composable(Rotas.TelaIngresso) { TelaIngresso(navController) }
        composable(Rotas.TelaProgramacao) { TelaProgramacao(navController) }
        composable(Rotas.TelaCardapio) { TelaCardapio(navController) }
        composable(Rotas.TelaComanda) { TelaComanda(navController) }
        composable(Rotas.TelaAniversario) { TelaAniversario(navController) }
        composable(Rotas.TelaGaleria) { TelaGaleria(navController) }
        composable(Rotas.TelaChapelaria) { TelaChapelaria(navController) }
        composable(Rotas.TelaAchados) { TelaAchados(navController) }
        composable(Rotas.TelaFaleConosco) { TelaFaleConosco(navController) }
    }
}





