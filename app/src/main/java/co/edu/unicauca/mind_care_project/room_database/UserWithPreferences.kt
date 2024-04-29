package co.edu.unicauca.mind_care_project.room_database

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithPreferences(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val preferences: List<Preferences>
)