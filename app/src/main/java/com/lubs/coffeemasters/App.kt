package com.lubs.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
    Scaffold (
        topBar = {
            // Automatic background color and height
            TopAppBar() {
                AppTitle()
            }
        },
        bottomBar ={

        }
    ){
        OfferPage()
    }
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