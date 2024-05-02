package co.edu.unicauca.mind_care_project.room_database.dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import co.edu.unicauca.mind_care_project.room_database.entities.Post
import co.edu.unicauca.mind_care_project.room_database.entities.User

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(postUser: Post)
    @Update
    suspend fun update(postUser: Post)
    @Delete
    suspend fun delete(postUser: Post)
    @Query("SELECT * from post WHERE id= :id")
    fun getPost(id:Int):Flow<User>
    @Query("SELECT * from post ")
    fun getPostList():Flow<List<Post>>
    @Query("SELECT * FROM post WHERE id = :userId")
    suspend fun getPostsUser(userId: Int): List<Post>
}