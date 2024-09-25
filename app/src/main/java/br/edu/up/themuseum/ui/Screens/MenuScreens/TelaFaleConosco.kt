package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaFaleConosco(navController: NavController) {
    var mensagem = remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopBarTelas(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
                Text(text = "Fale conosco", fontSize = 30.sp)
                TextField(
                    value = mensagem.value,
                    onValueChange = { mensagem.value = it },
                    label = { Text("Sua mensagem") },
                    modifier = Modifier.padding(bottom = 60.dp),
                    maxLines = 10,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Gray,
                        cursorColor = Color.Black
                    )
                )
            }
        },
        floatingActionButton = { FloatButton() }
    )
}

@Composable
fun FloatButton() {
    FloatingActionButton(onClick = { },
        containerColor = Color.Black) {
        Text(
            text = "Enviar",
            color = Color.White
        )
    }
}
