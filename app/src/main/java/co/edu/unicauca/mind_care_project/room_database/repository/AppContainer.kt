package co.edu.unicauca.mind_care_project.room_database.repository

import android.content.Context
import co.edu.unicauca.mind_care_project.room_database.InstanceDatabaseMindCare

interface AppContainer {
    val userRepository: UserRepository
}
/**
 * [AppContainer] implementation that provides instance of [OfflineUserRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [UserRepository]
     */
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(InstanceDatabaseMindCare.getDatabase(context).userDao())
    }
}


