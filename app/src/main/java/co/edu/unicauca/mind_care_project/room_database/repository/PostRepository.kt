package co.edu.unicauca.mind_care_project.room_database.repository

import co.edu.unicauca.mind_care_project.room_database.UserWithPost
import co.edu.unicauca.mind_care_project.room_database.entities.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getAllPostsStream(): Flow<List<Post>>

    /**
     * Retrieve an post from the given data source that matches with the [id].
     */
    fun getPostStream(id: Int): Flow<Post?>

    /**
     * Insert post in the data source
     */
    suspend fun insertPost(post: Post)

    /**
     * Delete post from the data source
     */
    suspend fun deletePost(post: Post)

    /**
     * Update post in the data source
     */
    suspend fun updatePost(post: Post)
    /**/
    suspend fun getPostsUser(id: Int):  Flow<List<Post>>

}