package co.edu.unicauca.mind_care_project.room_database.entities
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "preferences")
data class Preferences (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0 ,
    val item: String = ""
)