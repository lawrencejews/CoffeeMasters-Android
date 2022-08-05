package com.lubs.coffeemasters


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lubs.coffeemasters.ui.theme.Alternative1
import com.lubs.coffeemasters.ui.theme.OnPrimary

data class BottomNavigation(var name: String, var icon: ImageVector, var route: String)

object  Routes {
    val MenuPage = BottomNavigation("Menu", Icons.Outlined.Menu, "menu")
    val OfferPage = BottomNavigation("Offers", Icons.Outlined.Star, "menu")
    val OrderPage = BottomNavigation("My Order", Icons.Outlined.ShoppingCart, "menu")
    val InfoPage = BottomNavigation("Info", Icons.Outlined.Info, "menu")

    val pages = listOf(MenuPage, OfferPage, OrderPage, InfoPage)
}

@Preview
@Composable
fun BottomNavigation_Preview(){ // Custom modifier applied to the root property.
    NavBarItem(page = Routes.MenuPage, modifier = Modifier.padding(8.dp))
}

@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route,
            onChange: (String) -> Unit
           ){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ){    // Render one nav item at a time
        for(page in Routes.pages){
            NavBarItem(page = page,
            selected = selectedRoute == page.route,
            modifier = Modifier.clickable {
    onChange(page.route)
            }
                )
        }
    }
}

@Composable
fun NavBarItem(page: BottomNavigation, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) OnPrimary else Alternative1
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected)  OnPrimary else Alternative1
        )
    }
}