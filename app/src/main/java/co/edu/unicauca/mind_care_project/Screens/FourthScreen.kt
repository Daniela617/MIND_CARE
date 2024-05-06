package co.edu.unicauca.mind_care_project.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.unicauca.mind_care_project.R
import co.edu.unicauca.mind_care_project.UserInfo
import co.edu.unicauca.mind_care_project.UsersMessages
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import java.util.UUID
import kotlin.random.Random


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FourScreen(onClick: (String) -> Unit){
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )
    val db = Firebase.database // Inicializo instancia de fireBase
    val refDb = db.getReference()
    val id = "refDb"+ UUID.randomUUID().toString()
    var publication by remember { mutableStateOf("") }
    val onTextChange: (String) -> Unit = { newText ->
        publication = newText
    }
    //cargo los datos de los mensajes en firebase
    val userInfoList = UsersMessages.getUserInfo()
    val messageRef = refDb.child("Messages").child(id)
    messageRef.child("MessagesUser").setValue(userInfoList)

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
                            onClick = { onClick("fourScreen") }
                        )
                        BottomAppBarItem(
                            iconId = R.drawable.streamline_health_care_2,
                            label = "Cuidados",
                            onClick = { }
                        )
                        BottomAppBarItem(
                            iconId = R.drawable.terapiavec,
                            label = "Terapia",
                            onClick = {}
                        )

                    }
                }
            )
        }

    ){
        Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente)
    ) {
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
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onClick("SixScreen") }
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
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onClick("fiveScreen") }
                    )

                }
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar1),
                        contentDescription = "Avatar1",
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TextField(
                        value = publication,
                        onValueChange = onTextChange,
                        colors = TextFieldDefaults.colors(

                            unfocusedIndicatorColor = Color.Transparent, // Oculta el indicador cuando no está enfocado
                            focusedIndicatorColor = Color.Transparent, // Oculta el indicador cuando está enfocado
                            unfocusedContainerColor = Color.White, // Color del contenedor cuando no está enfocado
                            focusedContainerColor = Color.White
                        ),
                        placeholder = {
                            Text(stringResource(R.string.publication_placeholder), color = Color.Gray)
                        },
                        modifier = Modifier
                            .size(width = 250.dp, height = 60.dp),
                        shape = RoundedCornerShape(40.dp),
                    )

                }
                Row(modifier = Modifier.padding(all = 8.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    ) {
                        Divider(color = Color.White, thickness = 1.dp)
                    }
                }

                MultipleAvatars(userInfoList = userInfoList)

            }

        }
    }
    }
}

val iconMap = mapOf(
    2 to R.drawable.avatar2,
    3 to R.drawable.avatar3,
    4 to R.drawable.avatar4
)
@Composable
fun AvatarRow(userInfo: UserInfo) {
    val Purple = Color(0xFF9C27B0)
    val randomNumber = Random.nextInt(2, 5)
    val imageId = iconMap[randomNumber] ?: R.drawable.avatar2

    Row(
        modifier = Modifier.padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(imageId),
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