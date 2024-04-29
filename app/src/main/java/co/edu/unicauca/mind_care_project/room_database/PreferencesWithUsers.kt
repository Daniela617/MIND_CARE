package co.edu.unicauca.mind_care_project.room_database

import androidx.room.Embedded
import androidx.room.Relation

data class PreferencesWithUsers(
    @Embedded val preference: Preferences,
    @Relation(
        parentColumn = "id",
        entityColumn = "preferenceId"
    )
    val users: List<User>
)
