package com.example.shopinglist.ui.shoppinglist

import com.example.shopinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item : ShoppingItem)
}