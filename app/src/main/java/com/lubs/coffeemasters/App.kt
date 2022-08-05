package com.lubs.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.lubs.coffeemasters.pages.InfoPage
import com.lubs.coffeemasters.pages.MenuPage
import com.lubs.coffeemasters.pages.OfferPage
import com.lubs.coffeemasters.pages.OrderPage
import com.lubs.coffeemasters.ui.theme.CoffeeMastersTheme

@Preview
@Composable
fun App_Preview(){
    CoffeeMastersTheme {
        App()
    }
}

@Composable
fun App() {
    // Defining the state
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold (
        topBar = {
            // Automatic background color and height
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
                  when(selectedRoute.value){
                      Routes.MenuPage.route -> MenuPage()
                      Routes.OfferPage.route -> OfferPage()
                      Routes.OfferPage.route -> OfferPage()
                      Routes.OrderPage.route -> OrderPage()
                      Routes.InfoPage.route -> InfoPage()
                  }
        },
        bottomBar ={
        NavBar(
            selectedRoute = selectedRoute.value,
            onChange = { newRoute ->
            selectedRoute.value = newRoute
        })
        }
    )
}

@Composable
fun AppTitle(){

    // Wrapper for items vertically for th UI.
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters Logo")
    }
}