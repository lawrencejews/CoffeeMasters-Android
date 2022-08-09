package com.lubs.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.lubs.coffeemasters.DataManager
import com.lubs.coffeemasters.ItemInCart
import com.lubs.coffeemasters.Product
import com.lubs.coffeemasters.ui.theme.Primary

@Composable
fun OrderPage(dataManager: DataManager){
LazyColumn(){
    if(dataManager.cart.count() == 0){
    item{
        Card(
           elevation = 4.dp,
           modifier = androidx.compose.ui.Modifier
               .padding(16.dp)
        ){
            Text("Your order is empty",
                style = MaterialTheme.typography.h4
            )
        }
    }
    }
    items(dataManager.cart){
    CardItem(it, onDelete = {
        dataManager.cartRemove(it)
    } )
    }
}
}

@Composable
fun CardItem(it:ItemInCart, onDelete: (Product)->Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = androidx.compose.ui.Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "${it.quantity}x")
        Text(it.product.name,
        modifier = androidx.compose.ui.Modifier.width(150.dp)
            )
        Text("${(it.quantity*it.product.price).format(2)}",
        modifier = androidx.compose.ui.Modifier.width(50.dp)
        )
        Image(imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            }
            )
    }
}