package com.example.shopinglist.data.repositories

import com.example.shopinglist.data.db.ShoppingDatabase
import com.example.shopinglist.data.db.entities.ShoppingItem

class ShoppingRepositories (
    private val db : ShoppingDatabase
){
    fun upsert(item : ShoppingItem) = db.getShoppingDao().upsert(item)

    fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}