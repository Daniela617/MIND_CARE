package co.edu.unicauca.mind_care_project.room_database.repository
import co.edu.unicauca.mind_care_project.room_database.UserWithPost
import co.edu.unicauca.mind_care_project.room_database.UserWithPreferences
import co.edu.unicauca.mind_care_project.room_database.entities.User
import kotlinx.coroutines.flow.Flow
interface UserRepository {

    fun getAllUsersStream(): Flow<List<User>>

    /**
     * Retrieve an user from the given data source that matches with the [id].
     */
    fun getUserStream(id: Int): Flow<User?>

    /**
     * Insert user in the data source
     */
    suspend fun insertUser(user: User)

    /**
     * Delete user from the data source
     */
    suspend fun deleteUser(user: User)

    /**
     * Update user in the data source
     */
    suspend fun updateUser(user: User)

    /**/
    fun getUserPosts(id: Int): UserWithPost?

}