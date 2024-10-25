package br.edu.up.themuseum.ui.Screens.MenuScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.themuseum.R
import br.edu.up.themuseum.ui.Screens.Util.TopBarTelas
import br.edu.up.themuseum.ui.theme.ModakFont

@Composable
fun TelaAniversario(navController: NavController) {
    Scaffold(
        topBar = { TopBarTelas(navController) },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Text(text = "Aniversário", fontFamily = ModakFont
                    )
            }
        }
    )
}

