package co.edu.unicauca.mind_care_project.room_database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
interface PreferencesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(preferences: Preferences)
    @Update
    suspend fun update(preferences: Preferences)
    @Delete
    suspend fun delete(preferences: Preferences)
    @Query("SELECT * from preferences WHERE id= :id")
    fun getPreference(id:Int):Flow<Preferences>
    @Query("SELECT * from preferences ORDER BY item  ASC")
    fun getPreferencesList():Flow<List<Preferences>>
}