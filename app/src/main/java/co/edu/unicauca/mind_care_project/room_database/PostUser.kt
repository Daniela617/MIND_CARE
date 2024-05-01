package co.edu.unicauca.mind_care_project.room_database
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "post")
data class PostUser (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0 ,
    val contentPost: String = ""
)