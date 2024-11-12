package br.edu.up.themuseum

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.themuseum.ui.Screens.MenuScreens.HomeMenu
import br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso.TelaIngresso
import br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso.TelaPagamentoIngresso
import br.edu.up.themuseum.ui.Screens.MenuScreens.Ingresso.TelaPedidos
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaAchados
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaAniversario
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaCardapio
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaChapelaria
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaComanda
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaFaleConosco
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaGaleria
import br.edu.up.themuseum.ui.Screens.MenuScreens.TelaProgramacao


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
    const  val TELA_INGRESSO = "ingresso"
    const val TELA_PEDIDO = "pedido"
    const val TELA_PAGAMENTO = "pagamento"
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
        composable(Rotas.TELA_PEDIDO) { TelaPedidos(navController)}
        composable(Rotas.TELA_PAGAMENTO) { TelaPagamentoIngresso(navController) }
        composable(Rotas.TELA_INGRESSO) { TelaIngresso( navController) }
    }
}





