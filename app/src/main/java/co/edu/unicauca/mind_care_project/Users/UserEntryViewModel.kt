package co.edu.unicauca.mind_care_project.Users

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import co.edu.unicauca.mind_care_project.room_database.entities.User
import co.edu.unicauca.mind_care_project.room_database.repository.UserRepository


/* ViewModel para validar e insertar elementos en la base de datos de Room.
*/
class UserEntryViewModel(private val userRepository: UserRepository) : ViewModel() {
    /**
     * Mantiene el estado actual de la interfaz de usuario del elemento
     */

    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }
    /**
     * Inserts an User in the Room database
     */
    suspend fun saveUser() {
        if (validateInput()) {
            userRepository.insertUser(userUiState.userDetails.toUser())
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            username.isNotBlank()
        }
    }
}


data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val id: Int = 0,
    val username: String = ""

)

fun UserDetails.toUser(): User = User(
    userId =  id,
    username = username,
)


