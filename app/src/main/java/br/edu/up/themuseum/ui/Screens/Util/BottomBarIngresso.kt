package br.edu.up.themuseum.ui.Screens.Util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.edu.up.themuseum.R
import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.theme.PretoMostarda
import br.edu.up.themuseum.ui.theme.Verde
import br.edu.up.themuseum.ui.theme.VerdeMenta
import br.edu.up.themuseum.ui.theme.VerdeMostarda
import br.edu.up.themuseum.ui.theme.VerdeMusgo


@Composable
fun BottomBar(navController: NavController) {

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    NavigationBar(containerColor = Color(0xFF7B8373)) {


        NavigationBarItem(
            selected = currentRoute == Rotas.TELA_INGRESSO,
            onClick = {
                navController.navigate(Rotas.TELA_INGRESSO) {

                    popUpTo(Rotas.TELA_INGRESSO) { inclusive = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.bilhetes),
                    contentDescription = "ingresso",
                    modifier = Modifier.size(50.dp),
                    colorFilter = ColorFilter.tint(
                        if (currentRoute == Rotas.TELA_INGRESSO)VerdeMenta  else PretoMostarda
                    )
                )
            },
        )


        NavigationBarItem(
            selected = currentRoute == Rotas.listar_pedidos,
            onClick = {
                navController.navigate(Rotas.listar_pedidos) {

                    popUpTo(Rotas.listar_pedidos) { inclusive = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.pedido),
                    contentDescription = "pedido",
                    modifier = Modifier.size(50.dp),
                    colorFilter = ColorFilter.tint(
                        if (currentRoute == Rotas.listar_pedidos) VerdeMenta else PretoMostarda
                    )
                )
            },
        )


        NavigationBarItem(
            selected = currentRoute == Rotas.TELA_PAGAMENTO,
            onClick = {
                navController.navigate(Rotas.TELA_PAGAMENTO) {

                    popUpTo(Rotas.TELA_PAGAMENTO) { inclusive = true }
                }
            },
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.pagamento),
                    contentDescription = "pagamento",
                    modifier = Modifier.size(50.dp),
                    colorFilter = ColorFilter.tint(
                        if (currentRoute == Rotas.TELA_PAGAMENTO) VerdeMenta else PretoMostarda
                    )
                )
            },
        )
    }


    Divider(color = VerdeMenta, thickness = 1.dp)
}



