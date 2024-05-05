package co.edu.unicauca.mind_care_project.Screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.unicauca.mind_care_project.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun SecondScreen(onClick: (String) -> Unit) {

    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )

    var username by remember { mutableStateOf("") }
    val onTextChange: (String) -> Unit = { newText ->
        username = newText
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente)
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp)
                    .height(IntrinsicSize.Min)
                    .weight(0.3f)
            ){
                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center

                ) {
                    IconButton(onClick = { onClick("firstScreen") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Regresa",
                            modifier = Modifier.size(200.dp),
                            tint = Color.White
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iconproject),
                        contentDescription = "icono central",
                        modifier = Modifier.size(200.dp)
                    )
                }

            }
            Row(
                modifier = Modifier
                    .weight(0.7f)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los elementos de la columna
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp) // Ajusta este valor para mover el contenido hacia abajo desde el borde superior
                ) {

                    Text(
                        text = "Hola! Nos alegra tenerte aquí",
                        color = Color.White,
                        fontSize = 40.sp,
                        style = TextStyle(lineHeight = 40.sp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.nunito_bold, FontWeight.Bold)),
                        modifier = Modifier.padding(bottom = 40.dp,start = 40.dp, end = 40.dp,)
                    )
                    Text(
                        text = "Tus conversaciones son completamente privadas, así que no es necesario que inicies sesión. Elige un apodo y estaremos listos para comenzar.",
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.nunito, FontWeight.Normal)),
                        modifier = Modifier.padding(start = 40.dp, end = 40.dp, bottom = 140.dp)

                    )


                    Row(
                        modifier = Modifier
                            .size(width = 340.dp, height = 70.dp)
                            .background(Color.White, shape = RoundedCornerShape(40.dp))
                            .padding(8.dp)
                    ) {
                        TextField(
                            value = username,
                            onValueChange = onTextChange,
                            colors = TextFieldDefaults.colors(

                                unfocusedIndicatorColor = Color.Transparent, // Oculta el indicador cuando no está enfocado
                                focusedIndicatorColor = Color.Transparent, // Oculta el indicador cuando está enfocado
                                unfocusedContainerColor = Color.White, // Color del contenedor cuando no está enfocado
                                focusedContainerColor = Color.White
                            ),
                            placeholder = {
                                Text(stringResource(R.string.username_placeholder), color = Color.Gray)
                            },
                            modifier = Modifier
                                .size(width = 250.dp, height = 60.dp),
                            shape = RoundedCornerShape(40.dp),
                        )

                        BotonEjemplo(onClick = onClick, username = username)
                        Log.d("NombreUsuario", "El nombre de usuario es: $username")
                    }

                }
            }
        }

    }

}



@Composable
fun BotonEjemplo(
    onClick: (String) -> Unit,

    username: String
){
    val db = Firebase.database
    val refDb =db.getReference()
    val id = UUID.randomUUID().toString()

    val coroutineScope = rememberCoroutineScope()
    Button(onClick = {
        val usersRef = db.reference.child("Users")
        val userRef = usersRef.child(id)
        val user = User(username)
        userRef.setValue(user)
        coroutineScope.launch {

            onClick("thirdScreen")
        }


    },
        shape = CircleShape,
        modifier = Modifier,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E66B8)))
    {
        Icon(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = "Siguiente",
            modifier = Modifier
                .padding(3.dp),
            tint = Color.White
        )
    }
}

data class User( val username: String)