package co.edu.unicauca.mind_care_project.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.unicauca.mind_care_project.R

@Composable
fun FirstScreen(onClick: (String) -> Unit) {
// Gradiente
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF4FB5BC), Color(0xFF0B5884))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente),
        contentAlignment = Alignment.TopCenter // contenido en la parte superior central
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            // Centra horizontalmente los elementos de la columna
            // verticalArrangement = Arr,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp) // Ajusta este valor para mover el contenido hacia abajo desde el borde superior
        ) {
            // Imagen
            Image(
                painter = painterResource(id = R.drawable.iconproject),
                contentDescription = "Icono de la aplicación",
                modifier = Modifier
                    .size(290.dp)
                    .padding(bottom = 8.dp)//pongo la imagen mas arriba
            )
            Text(
                text = "MIND CARE",
                color = Color.White,
                fontSize = 45.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold, FontWeight.Bold)),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = "Inicia tu viaje hacia el equilibrio emocional y la serenidad",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.nunito, FontWeight.Normal)),
                modifier = Modifier.padding(start = 40.dp, end = 40.dp, bottom = 140.dp)

            )
            Button(
                onClick ={ onClick("secondScreen")},
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
            Text(
                text = "No tienes cuenta?",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.nunito, FontWeight.Normal)),
                modifier = Modifier.padding(top=15.dp)

            )

        }
    }
}

