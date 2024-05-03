package co.edu.unicauca.mind_care_project.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(primaryKeys = ["userId","preferenceId"])
data class UserPreferences(
    val userId: Int,
    val preferenceId: Int
)


