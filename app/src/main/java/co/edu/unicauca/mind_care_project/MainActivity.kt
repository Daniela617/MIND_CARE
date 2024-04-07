package co.edu.unicauca.mind_care_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.edu.unicauca.mind_care_project.ui.theme.Mind_care_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mind_care_projectTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "secondScreen") {
        composable("firstScreen") { firstScreen(navController) }
        composable("secondScreen") { secondScreen(navController) }
        composable("thirdScreen") { thirdScreen(navController) }

        composable("fourScreen") { FourScreen(navController) }
        composable("fiveScreen") { FiveScreen(navController) }

    }
}

@Composable
fun firstScreen(navController: NavController) {
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
                onClick = {navController.navigate("secondScreen")},
                colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF8E66B8) ),
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



@Composable
fun secondScreen(navController: NavController) {
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )

    var text =""

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
                    IconButton(onClick = { navController.navigate("firstScreen") }) {
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
                                value = "",
                                onValueChange = {},
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
                            Spacer(modifier = Modifier.height(16.dp))
                                    //TODO ICON
                            Button(onClick = {navController.navigate("fiveScreen") },
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(50.dp) ,
                               colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E66B8)))
                            {
                                Icon(
                                    painter = painterResource(id = R.drawable.back),
                                    contentDescription = "Regresa",
                                    modifier = Modifier
                                        .size(200.dp)
                                        .padding(3.dp),
                                    tint = Color.White
                                )
                            }
                        }

                    }
                }
            }

        }

    }


@Composable
fun thirdScreen(navController: NavController) {
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
                onClick = {navController.navigate("FourScreen")},
                colors = ButtonDefaults.buttonColors(containerColor =Color(0xFF8E66B8) ),
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
@Preview
@Composable
fun ThirdScreenPreview() {
    val navController = rememberNavController()
    thirdScreen(navController)
}

@Composable
fun FourScreen(navController: NavController){
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )
    val Purple = Color(0xFF9C27B0)
    val userInfoList = UsersMessages.getUserInfo()
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradiente)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(25.dp)
            ) {

                Text(
                    text = "Mind Care",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_bold, FontWeight.Bold)),
                    textAlign = TextAlign.Left
                )
                Spacer(modifier = Modifier.width(110.dp))
                Image(
                    painter = painterResource(R.drawable.iconobusqueda),
                    contentDescription = "Icono de búsqueda",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.globos_de_texto),
                    contentDescription = "Mensajes",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(R.drawable.rueda_dentada),
                    contentDescription = "Configuración",
                    modifier = Modifier.size(20.dp)
                )

            }
            Row(modifier = Modifier.padding(all = 8.dp),verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.avatar1),
                    contentDescription = "Avatar1",
                    modifier = Modifier
                        // Set image size to 40 dp
                        .size(60.dp)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "¿En qué estás pensando?",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
                    textAlign = TextAlign.Center
                )
            }
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)) {
                    Divider(color = Color.White, thickness = 1.dp)
                }
            }

            MultipleAvatars(userInfoList = userInfoList)
        }

    }
}
@Composable
fun AvatarRow(userInfo:UserInfo) {
    val Purple = Color(0xFF9C27B0)

    Row(
        modifier = Modifier.padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(userInfo.imageId),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(2.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = userInfo.user,
            color = Color.White,
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
            textAlign = TextAlign.Center
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = userInfo.contentText,
                    color = Purple,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
                    textAlign = TextAlign.Justify
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.me_gusta),
                    contentDescription = "Like",
                    modifier = Modifier.size(10.dp)
                )
            }
        }

    }
}
@Composable
fun MultipleAvatars(userInfoList: List<UserInfo>) {
    LazyColumn {
        items(userInfoList) { userInfo ->
            AvatarRow(userInfo = userInfo)
        }
    }
}

@Composable
fun FiveScreen(navController: NavController) {
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )
    //

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
                    IconButton(onClick = {navController.navigate("fourScreen")}) {
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
                            shape = RoundedCornerShape(30.dp) // Esquinas redondeadas a 8.dp
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

        //

    }


