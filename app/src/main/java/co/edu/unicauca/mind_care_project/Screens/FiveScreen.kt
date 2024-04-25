package co.edu.unicauca.mind_care_project.Screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.unicauca.mind_care_project.R


@Composable
fun  BottomAppBarItem(
    @DrawableRes iconId: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Icon( painter = painterResource(id = iconId), contentDescription = label,tint = Color.White)
        Text(label, color = Color.White)
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FiveScreen(onClick: (String) -> Unit) {
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )

    //
    Scaffold(
        bottomBar = {

            BottomAppBar(
                containerColor = Color(0xFF8E66B8),
                content = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        BottomAppBarItem(
                            iconId = R.drawable.mynaui_home,
                            label = "Inicio",
                            onClick = {  onClick("fourScreen") }
                        )
                        BottomAppBarItem(
                            iconId = R.drawable.streamline_health_care_2,
                            label = "Cuidados",
                            onClick = { /* TODO */ }
                        )
                        BottomAppBarItem(
                            iconId = R.drawable.terapiavec,
                            label = "Terapia",
                            onClick = { /* TODO" */ }
                        )
                        BottomAppBarItem(
                            iconId = R.drawable.sosvec,
                            label = "SOS",
                            onClick = { /* TODO */ }
                        )
                    }
                }
            )
        }

    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradiente)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 80.dp)
                        .height(IntrinsicSize.Min)
                        .weight(0.25f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(0.3f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center

                    ) {
                        IconButton(onClick = {onClick("fourScreen") }) {
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
                            .weight(0.75f)
                            .fillMaxHeight()
                            .padding(start = 50.dp)
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.avatar1),
                                contentDescription = "avatar",
                                modifier = Modifier.size(100.dp)
                            )
                        }


                    }


                }
                Row(
                    modifier = Modifier
                        .weight(0.65f)
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los elementos de la columna
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp) // Ajusta este valor para mover el contenido hacia abajo desde el borde superior
                    ) {
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E66B8)),
                            modifier = Modifier
                                .width(150.dp)
                                .height(40.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Adquiere premium",
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(25.dp))
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Personaliza tu cuenta",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        //
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Guarda tu proceso",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(42.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        //
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Notificaciones",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(80.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        //
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                "Cambiar idioma",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(70.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        //
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Soporte",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(138.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        //
                        Button(
                            onClick = {/**/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            modifier = Modifier
                                .width(320.dp)
                                .height(50.dp),
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
                        ) {
                            Text(
                                "Política de privacidad",
                                color = Color.Gray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(3.dp)
                            )
                            Spacer(modifier = Modifier.width(13.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForward, // Icono de flecha
                                contentDescription = "Icono de flecha",
                                tint = Color.Gray, // Color del icono,
                                modifier = Modifier.offset(y = 2.dp)
                            )
                        }


                    }
                }


            }

        }
    }
}