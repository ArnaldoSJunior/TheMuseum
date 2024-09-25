package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import java.time.LocalDate
import java.time.LocalTime


@Composable
fun TelaProgramacao(navController: NavController) {
    var Eventos = mutableListOf(
        Evento(
            titulo = "SHOW INTERNCAIONAL",
            Data = LocalDate.of(2024,12,21),
            Horario = LocalTime.of(14,0),
            Ingresso = 60.0
        ),
        Evento(
            titulo = "SHOW NACIONAL",
            Data = LocalDate.of(2024,12,22),
            Horario = LocalTime.of(14,0),
            Ingresso = 60.0
        )
    )
    Scaffold(
        topBar = { TopBarTelas(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "Programação", fontSize = 30.sp)
                for (Evento in Eventos) {
                    Text(text = "${Evento.titulo}", fontSize = 20.sp)
                    Text(text = "\n Data:${Evento.Data} \n Horário:${Evento.Horario} \n Ingresso: R$${Evento.Ingresso}\n")
                }
            }
        }
    )
}
data class Evento(
    var titulo: String,
    var Data: LocalDate ,
    var Horario:LocalTime,
    var Ingresso: Double

)