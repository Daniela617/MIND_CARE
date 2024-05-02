package co.edu.unicauca.mind_care_project.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int,
    val preferenceId: Int
)

