package co.edu.unicauca.mind_care_project.room_database.entities
import androidx.room.Entity;
import androidx.room.ForeignKey
import androidx.room.PrimaryKey;
@Entity(
    tableName = "post",
    foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE
)])
data class Post (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0 ,
    val userId: Int = 0 ,
    val contentPost: String = ""
)