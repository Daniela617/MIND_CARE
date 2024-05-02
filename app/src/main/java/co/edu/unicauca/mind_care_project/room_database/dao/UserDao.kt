package co.edu.unicauca.mind_care_project.room_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import co.edu.unicauca.mind_care_project.room_database.UserWithPost
import co.edu.unicauca.mind_care_project.room_database.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)
    @Update
    suspend fun update(user: User)
    @Delete
    suspend fun delete(user: User)
    @Query("SELECT * from users WHERE id= :id")
    fun getUser(id:Int):Flow<User>
    @Query("SELECT * from users ORDER BY username ASC")
    fun getUserList():Flow<List<User>>
    @Transaction
    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserPosts(id: Int): UserWithPost?
}