package com.example.ozen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.layout_item.*


class ListCard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setupViews()


    }
    private fun setupViews() {
        list_view.layoutManager = LinearLayoutManager(this)

        /*val itemImages = intArrayOf(
            R.drawable.david,
            R.drawable.ramazan,
            R.drawable.em
        )*/

        val items = mutableListOf(
            Item(title = "The David Roy Collective", /*image = item_image,*/ content = "The Old House"),
            Item(title = "Ramazan Stamgaziyev", /*image = item_image,*/ content = "Dariga dauren"),
            Item(title = "Eminem", /*image = item_image,*/ content = "Beautiful"),
            Item(title = "AC/DC", /*image = item_image, */content = "Back in Black"),
            Item(title = "NF", /*image = item_image, */content = "Let You Down"),
            Item(title = "jeltoksan., dudeontheguitar feat. Mountflower", /*image = item_image, */content = "Chill Chill"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6"),
            Item(title = "Title 6", /*image = item_image,*/ content = "Content 6")


        )



        list_view.adapter = ItemsAdapter(items = items,
            onItemClick =  {
                list_view.setOnClickListener {
                    val intent = Intent (this, Podcasts::class.java)
                    startActivity(intent)
                }

                back.setOnClickListener {
                    /*********************************************************/
                    /*val mutableList = items.toMutableList()
                    for (i in items.indices) {
                        println(i)
                        println(items[i])
                        mutableList.removeAt(0)
                    }*/

                   /* fun removeItem(position: Int) {
                        items.removeAt(position)
                    }*/

                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent)
                }


            }
            )
    }
}

