package co.edu.unicauca.mind_care_project.room_database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import co.edu.unicauca.mind_care_project.room_database.entities.Preferences
import co.edu.unicauca.mind_care_project.room_database.entities.User
import co.edu.unicauca.mind_care_project.room_database.entities.UserPreferences

data class UserWithPreferences(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "preferenceId",
        associateBy = Junction(UserPreferences::class)
    )
    val preferences: List<Preferences>
)