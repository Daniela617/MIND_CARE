package co.edu.unicauca.mind_care_project.room_database

import androidx.room.Embedded
import androidx.room.Relation
import co.edu.unicauca.mind_care_project.room_database.entities.Post
import co.edu.unicauca.mind_care_project.room_database.entities.User

data class UserWithPost(
    @Embedded val user: User,
    @Relation(
        parentColumn = "postId",
        entityColumn = "userId"
    )
    val posts: List<Post>
)