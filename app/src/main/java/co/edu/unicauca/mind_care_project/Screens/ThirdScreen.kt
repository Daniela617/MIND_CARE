package co.edu.unicauca.mind_care_project
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun thirdScreen(onClick: (String) -> Unit) {
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente)
    ) {
        Text(
            text = "Personalicemos tu\nespacio",
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Agrega margen horizontal a la LazyColumn
            verticalArrangement = Arrangement.spacedBy(40.dp) // Espacio entre filas
        ) {
            val itemsEnGruposDeDos = listaDeItems.chunked(2) // Agrupa en pares
            items(itemsEnGruposDeDos) { items ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly // Distribuye uniformemente
                ) {
                    items.forEach { item ->
                        // Agrega un Spacer entre cada elemento
                        if (items.indexOf(item) != 0) {
                            Spacer(modifier = Modifier.width(30.dp))
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f) // Peso igual para cada elemento de la columna
                                .background(Color.White, RoundedCornerShape(8.dp))
                                .padding(horizontal = 24.dp, vertical = 32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = item.nombre,
                                color = Color(0xFF8E66B8),
                                fontSize = 23.sp
                            )
                        }
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {onClick("FourScreen")},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E66B8) ),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
            ) {
                Text("COMENCEMOS",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center ,
                    modifier = Modifier.padding(3.dp)
                )
            }
        }
    }

}

data class Item(val nombre: String)

val listaDeItems = listOf(
    Item("Ansiedad"),
    Item("Depresión"),
    Item("Relaciones"),
    Item("Soledad"),
    Item("Traumas"),
    Item("Embarazo"),
    Item("Tristeza"),
    Item("Sueño")
)