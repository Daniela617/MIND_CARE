package co.edu.unicauca.mind_care_project.room_database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [User::class, Preferences::class], version = 1, exportSchema = false)
abstract class InstanceDatabaseMindCare : RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun preferencesDao(): PreferencesDao

    companion object{
        @Volatile
        private var Instance: InstanceDatabaseMindCare? = null

        fun getDatabase(context: Context) : InstanceDatabaseMindCare{
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InstanceDatabaseMindCare::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}