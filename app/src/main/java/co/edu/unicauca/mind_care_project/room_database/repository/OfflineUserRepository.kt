package co.edu.unicauca.mind_care_project.room_database.repository

import co.edu.unicauca.mind_care_project.room_database.UserWithPost
import co.edu.unicauca.mind_care_project.room_database.dao.UserDao
import co.edu.unicauca.mind_care_project.room_database.entities.User
import kotlinx.coroutines.flow.Flow

class OfflineUserRepository( private val userDao: UserDao) : UserRepository {

    override fun getAllUsersStream(): Flow<List<User>> = userDao.getUserList()

    override fun getUserStream(id: Int): Flow<User?> = userDao.getUser(id)

    override suspend fun insertUser(user: User) = userDao.insert(user)

    override suspend fun deleteUser(user: User) = userDao.delete(user)

    override suspend fun updateUser(user: User) = userDao.update(user)

    override fun getUserPosts(id: Int): UserWithPost? {
        // Aquí podrías implementar la lógica para obtener los posts de un usuario cuando estás offline
        // Por ejemplo, podrías obtener los posts almacenados localmente en la base de datos
        // o mostrar un mensaje de error indicando que no se pueden obtener los posts sin conexión a Internet.
        return null
    }
}