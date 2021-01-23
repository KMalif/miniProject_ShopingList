package com.example.shopinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shopinglist.data.db.entities.ShoppingItem
import com.example.shopinglist.data.repositories.ShoppingRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ShoppingViewModel (
    private val repository : ShoppingRepositories
):ViewModel() {

    fun upsert(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }
     fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.Main).launch{
         repository.delete(item)
     }
    fun getAllShoppingItems() = repository.getAllShoppingItems()
}