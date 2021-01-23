package com.example.shopinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopinglist.R
import com.example.shopinglist.data.db.entities.ShoppingItem
import com.example.shopinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.item_shopping.view.*

class ShoppingListAdapter(
    var items : List<ShoppingItem>,
    private val viewmodel : ShoppingViewModel): RecyclerView.Adapter<ShoppingListAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemview : View): RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
       val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = "${currentShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewmodel.delete(currentShoppingItem)
        }
        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewmodel.upsert(currentShoppingItem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if (currentShoppingItem.amount>0){
                currentShoppingItem.amount--
                viewmodel.upsert(currentShoppingItem)
            }
        }
    }
}