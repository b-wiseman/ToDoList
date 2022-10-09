package com.musabnasr.todolistproject

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val itemList = mutableListOf(
        Item("To Do List Item 1"),
        Item("To Do List Item 2"),
        Item("To Do List Item 3"),
        Item("To Do List Item 4"),
        Item("To Do List Item 5"),
        Item("To Do List Item 6"),
        Item("To Do List Item 7"),
        Item("To Do List Item 8")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListAdapter(itemList)
        }




        val swipeToDeleteCallback = object : SwipeToDeleteCallback(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                itemList.removeAt(position)
                recyclerView.adapter?.notifyItemRemoved(position)
            }

        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)

        itemTouchHelper.attachToRecyclerView(recyclerView)


    }

   /* private fun addListItem() {
        val dialogTitle = "Add New Task"
        val positiveButtonTitle = "Add"
        val negativeButtonTitle = "Cancel"
        val builder = AlertDialog.Builder(this)
        val newItemEditText = EditText(this)
        newItemEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(newItemEditText)
        builder.setPositiveButton(positiveButtonTitle) {
                dialog, id -> itemList.add(newItemEditText.text.toString())
            adapter.notifyDataSetChanged()
        }
        builder.setNegativeButton(negativeButtonTitle){
                dialog, id -> dialog.cancel()
        }
        builder.create().show()
    }*/

}

