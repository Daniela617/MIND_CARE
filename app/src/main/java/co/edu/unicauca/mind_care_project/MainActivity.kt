package co.edu.unicauca.mind_care_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import co.edu.unicauca.mind_care_project.Navigation.Navigation
import co.edu.unicauca.mind_care_project.ui.theme.Mind_care_projectTheme
import co.edu.unicauca.mind_care_project.Screens.FirstScreen
import co.edu.unicauca.mind_care_project.Screens.FiveScreen
import co.edu.unicauca.mind_care_project.Screens.FourScreen
import co.edu.unicauca.mind_care_project.Screens.IntroductionPage
import co.edu.unicauca.mind_care_project.Screens.SecondScreen
import co.edu.unicauca.mind_care_project.Screens.SixScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mind_care_projectTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "introductionPage") {
        composable("introductionPage") { IntroductionPage {
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }
        composable("firstScreen") { FirstScreen {
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }
        composable("secondScreen") { SecondScreen{
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }
        composable("thirdScreen") { thirdScreen{
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }

        composable("fourScreen") { FourScreen{
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }
        composable("fiveScreen") { FiveScreen{
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }
        composable("SixScreen") { SixScreen{
                destination ->
            Navigation.navigateToScreen(navController, destination)
        } }

    }
}







