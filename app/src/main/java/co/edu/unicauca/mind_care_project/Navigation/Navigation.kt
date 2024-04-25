package co.edu.unicauca.mind_care_project.Navigation

import androidx.navigation.NavController

object Navigation {
    fun navigateToScreen(navController: NavController, destination: String) {
        navController.navigate(destination)
    }
}