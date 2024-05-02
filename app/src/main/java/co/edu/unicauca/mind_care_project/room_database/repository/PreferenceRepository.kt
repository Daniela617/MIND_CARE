package co.edu.unicauca.mind_care_project.room_database.repository

import co.edu.unicauca.mind_care_project.room_database.entities.Post
import co.edu.unicauca.mind_care_project.room_database.entities.Preferences
import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    fun getAllPreferencesStream(): Flow<List<Preferences>>

    /**
     * Retrieve an preference from the given data source that matches with the [id].
     */
    fun getPreferenceStream(id: Int): Flow<Preferences?>

    /**
     * Insert preference in the data source
     */
    suspend fun insertPreference(preferences: Preferences)

    /**
     * Delete preference from the data source
     */
    suspend fun deletePreference(preferences: Preferences)

    /**
     * Update preference in the data source
     */
    suspend fun updatePreference(preferences: Preferences)
}