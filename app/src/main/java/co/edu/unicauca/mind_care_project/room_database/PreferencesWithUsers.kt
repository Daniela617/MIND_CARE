package co.edu.unicauca.mind_care_project.room_database

import androidx.room.Embedded
import androidx.room.Relation
import co.edu.unicauca.mind_care_project.room_database.entities.Preferences
import co.edu.unicauca.mind_care_project.room_database.entities.User

data class PreferencesWithUsers(
    @Embedded val preference: Preferences,
    @Relation(
        parentColumn = "id",
        entityColumn = "preferenceId"
    )
    val users: List<User>
)
