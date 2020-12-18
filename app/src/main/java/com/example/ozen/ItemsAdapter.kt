package com.example.ozen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

//fun onItemClick (item: Item) {}

class ItemsAdapter (

    private val items: List<Item> = listOf(),
    private val onItemClick: (Item) -> Unit
    /*private val itemImages: IntArray = intArrayOf(
        R.drawable.david,
        R.drawable.ramazan,
        R.drawable.em
    )*/
) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(item: Item) {
            view.title_view.text = item.title
            view.content_view.text = item.content
            //view.item_image.text = item.image

            view.setOnClickListener {
                onItemClick(item)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(items[position])
       /* holder.itemView.setOnClickListener { view: View ->
            Toast.makeText(view.context, "Clicked on the item", Toast.LENGTH_SHORT).show()

        }*/

    }

    override fun getItemCount() = items.size
}