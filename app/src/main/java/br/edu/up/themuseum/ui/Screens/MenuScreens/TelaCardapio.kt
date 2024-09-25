package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun TelaCardapio(navController: NavController) {
    var Cardapio = mutableListOf(
        Cardapios(
            bebida = "Água",
            preco = 5.0
        ),
        Cardapios(
            bebida = "Refrigerante",
            preco = 2.5
        ),
        Cardapios(
            bebida = "Suco",
            preco = 3.5
        )
    )
    Scaffold(
        topBar = { TopBarTelas(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "Cardápio", fontSize = 30.sp)
                Text(text = "Não Alcoólicos", fontSize = 20.sp)
                for (Cardapios in Cardapio ) {

                    Text(text = "${Cardapios.bebida} Preço: R$${Cardapios.preco}\n")
                }
            }
        }
    )
}
data class Cardapios(
    var bebida: String,
    var preco: Double

)