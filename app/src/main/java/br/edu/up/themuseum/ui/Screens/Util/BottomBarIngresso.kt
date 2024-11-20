package br.edu.up.themuseum.ui.Screens.Util

import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Rotas
import br.edu.up.themuseum.ui.theme.VerdeMostarda


@Composable
fun BottomBar(navController: NavController) {

    NavigationBar(containerColor = Color(0xFF7B8373)) {
        NavigationBarItem(
            selected = true,
            onClick = {
                navController.navigate(Rotas.TELA_INGRESSO)
            },
            icon = {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "A",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Ingressos") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(Rotas.listar_pedidos)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "B",
                    modifier = Modifier.size(40.dp)
                )
            },
            label = { Text(text = "Pedidos") }
        )
        NavigationBarItem( 
            selected = false,
            onClick = {
                navController.navigate(Rotas.TELA_PAGAMENTO)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Pagamento",
                    modifier = Modifier.size(40.dp),
                    tint = VerdeMostarda
                )
            },
            label = { Text(text = "Pagamento", color = Color.Magenta) }
        )
    }
}

