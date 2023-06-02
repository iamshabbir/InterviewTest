package com.example.interviewtest

data class MainItem(val int: Int, val item: List<Item>) {

}

val itemList = listOf(
    Item("TV ", 100000.0),
    Item("Air Condition ", 42000.0),
    Item("Air Cooler ", 2000.0),
    Item("fan ", 2000.0),
    Item("Refrigerator ", 50000.0),
    Item("Microwave ", 12000.0),
    Item("Hair Dryer ", 1500.0),
    Item("42 inch Tv ", 23000.0),
    Item("Mobile ", 10000.0),
    Item("Apple ", 10000.0),
    Item("Speaker ", 10000.0)
)
val itemList2 = listOf(
    Item("Jeans", 500.0),
    Item("Shirt", 1000.0),
    Item("Top", 1500.0),
    Item("Tshirt", 1000.0),
    Item("Inner", 100.0),
    Item("34 Jeans", 1000.0),
    Item("36 Jeans", 2000.0),
    Item("Pants", 10200.0),
    Item("Cotton pants", 1000.0),
    Item("linen shirt", 1200.0),
    Item("Tshirt", 100.0),

)
val mainItemList = listOf(
    MainItem(R.drawable.electric_offer, itemList),
    MainItem(R.drawable.clothing_offers, itemList2)
)