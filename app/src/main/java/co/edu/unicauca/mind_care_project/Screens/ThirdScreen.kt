package co.edu.unicauca.mind_care_project
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.database.database
import java.util.UUID
import co.edu.unicauca.mind_care_project.singleton.IdManager

@Composable
fun thirdScreen(onClick: (String) -> Unit) {
    val gradiente = Brush.verticalGradient(
        colors = listOf(Color(0xFF8E66B8), Color(0xFF0B5884))
    )
    val selectedItems = remember { mutableStateListOf<Item>() }
    val db = Firebase.database // Initialize Firebase Database instance
    val refDb = db.getReference()
    val id = "refDb"+ UUID.randomUUID().toString()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradiente)
            .padding(horizontal = 16.dp),

        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Personalicemos tu\nespacio",
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,

        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            LazyVerticalGrid(
                columns  =  GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement =Arrangement.spacedBy(30.dp) ,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(0.8f)

            ) {
                items(listaDeItems) { item ->
                    Box(
                        modifier = Modifier
                            .clickable(onClick= {
                                if (selectedItems.contains(item)) {
                                    selectedItems.remove(item)
                                } else {
                                    selectedItems.add(item)
                                }
                            })
                            .background(
                                if (selectedItems.contains(item)) Color(0xFFCEC2FD) else Color.White,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 24.dp, vertical = 32.dp)

                    ) {
                        Text(
                            text = item.nombre,
                            color = Color(0xFF8E66B8),
                            fontSize = 23.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(

                    onClick = {
                        // Add selected items to Firebase
                        val selectedItemsList = selectedItems.map { it.nombre }
                        val userRef = refDb.child("Items").child(id)
                        userRef.child("selectedItems").setValue(selectedItemsList)
                        val idRecibido = IdManager.getAssignId()
                        Log.d("usuario", "El id de usuario es: $idRecibido")
                        userRef.child("idUser").setValue(idRecibido)
                            .addOnSuccessListener {

                                println("Selected items saved to Firebase successfully!")
                            }
                            .addOnFailureListener { exception ->
                                println("Error saving selected items to Firebase: $exception")
                            }
                        onClick("FourScreen") // Proceed to next screen
                    },
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
}

data class Item(val nombre: String)

val listaDeItems = listOf(
    Item("Ansiedad"),
    Item("Depresión"),
    Item("Amor"),
    Item("Soledad"),
    Item("Traumas"),
    Item("Embarazo"),
    Item("Tristeza"),
    Item("Sueño")
)
