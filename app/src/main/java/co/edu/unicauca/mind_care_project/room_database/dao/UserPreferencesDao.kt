package co.edu.unicauca.mind_care_project.room_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import co.edu.unicauca.mind_care_project.room_database.PreferencesWithUsers
import co.edu.unicauca.mind_care_project.room_database.entities.UserPreferences
import co.edu.unicauca.mind_care_project.room_database.UserWithPreferences

@Dao
interface UserPreferencesDao {

    @Insert
    suspend fun insertUserPreferences(userPreferences: UserPreferences)//Permite insertar una entrada en la tabla intermedia.

    @Query("SELECT * FROM user_preferences")
    suspend fun getAllUserPreferences(): List<UserPreferences>//Obtiene todas las entradas de la tabla intermedia.

    @Transaction
    @Query("SELECT * FROM users")
    suspend fun getUsersWithPreferences(): List<UserWithPreferences>
    //Obtiene todos los usuarios con sus preferencias asociadas utilizando la clase de relación

    @Transaction
    @Query("SELECT * FROM preferences")
    suspend fun getPreferencesWithUsers(): List<PreferencesWithUsers>
    //Obtiene todas las preferencias con los usuarios asociados utilizando la clase de relación
}