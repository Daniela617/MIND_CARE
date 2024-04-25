package co.edu.unicauca.mind_care_project.Screens

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.unicauca.mind_care_project.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SixScreen(onClick: (String) -> Unit){
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )
    var searchText by remember { mutableStateOf("") }

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
                        co.edu.unicauca.mind_care_project.Screens.BottomAppBarItem(
                            iconId = R.drawable.mynaui_home,
                            label = "Inicio",
                            onClick = {  onClick("fourScreen") }
                        )
                        co.edu.unicauca.mind_care_project.Screens.BottomAppBarItem(
                            iconId = R.drawable.streamline_health_care_2,
                            label = "Cuidados",
                            onClick = { /* TODO */ }
                        )
                        co.edu.unicauca.mind_care_project.Screens.BottomAppBarItem(
                            iconId = R.drawable.terapiavec,
                            label = "Terapia",
                            onClick = { /* TODO */ }
                        )
                        co.edu.unicauca.mind_care_project.Screens.BottomAppBarItem(
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
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(15.dp)
                ) {

                    IconButton(onClick = {onClick("fourScreen") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Regresa",
                            modifier = Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        placeholder = {  Text(
                            text = "Busca",
                            style = TextStyle(fontSize = 14.sp),
                            textAlign= TextAlign.Center
                        )
                        },
                        singleLine = true
                    )

                }
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Reciente",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier= Modifier.padding(8.dp)
                    )
                }
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar2),
                        contentDescription = "Avatar2",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)

                            .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Anon555",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
                        textAlign = TextAlign.Center
                    )

                }
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.avatar3),
                        contentDescription = "Avatar2",
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                            //.padding(10.dp)
                            .border(1.5.dp, MaterialTheme.colorScheme.inversePrimary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "VisitanteX",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
                        textAlign = TextAlign.Center
                    )

                }
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(R.drawable.iconobusqueda),
                        contentDescription = "Busqueda",
                        modifier = Modifier
                            .size(25.dp)

                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Depresión",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_variable_font_wght)),
                        textAlign = TextAlign.Center
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
            }
        }
    }


}

