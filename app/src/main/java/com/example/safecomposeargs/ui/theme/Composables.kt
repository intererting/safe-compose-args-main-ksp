package com.example.safecomposeargs.ui.theme

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.plusAssign
import com.example.safecomposeargs.*
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import java.util.*

@Composable
fun DemoScreen() {
    val navController = rememberNavController()
    val graph = remember(navController) {
        NavigationGraph(navController)
    }

    NavHost(
        navController = navController,
        startDestination = HomePageDestination.getDestination()
    ) {
        composable(
            route = HomePageDestination.route,
            arguments = HomePageDestination.argumentList
        ) { backStackEntry ->
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "This is home page", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { graph.openUserPage(UUID.randomUUID().toString(), false) }) {
                        Text(text = "Go to user page", textAlign = TextAlign.Center)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { graph.openEndScreen("This is end screen") }) {
                        Text(text = "Go to end screen page", textAlign = TextAlign.Center)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { graph.openTncPage("End url") }) {
                        Text(text = "Go to tnc page", textAlign = TextAlign.Center)
                    }
                }
            }
        }

        composable(
            route = UserPageDestination.route,
            arguments = UserPageDestination.argumentList
        ) { backStackEntry ->
            val (userId, isLoggedIn) = UserPageDestination.parseArguments(backStackEntry)
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "This is user page with userId: $userId", textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Is user logged in $isLoggedIn", textAlign = TextAlign.Center)
                }
            }
        }

        composable(
            route = EndScreenDestination.route,
            arguments = EndScreenDestination.argumentList
        ) { backStackEntry ->
            val (endScreenText) = EndScreenDestination.parseArguments(backStackEntry)
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "This is end page with endText: $endScreenText", textAlign = TextAlign.Center)
                }
            }
        }

        composable(
            route = TncDestination.route,
            arguments = TncDestination.argumentList
        ) { backStackEntry ->
            val (tncUrl) = TncDestination.parseArguments(backStackEntry)
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "This is tnc page with tncUrl: $tncUrl", textAlign = TextAlign.Center)
                }
            }
        }
    }
}
