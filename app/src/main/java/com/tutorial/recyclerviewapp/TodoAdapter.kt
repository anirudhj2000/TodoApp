package com.tutorial.recyclerviewapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var todoList : MutableList<Card>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

   inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            val text1 = findViewById<TextView>(R.id.todoTask)
            val chk = findViewById<CheckBox>(R.id.checkbox)
            val del = findViewById<ImageView>(R.id.delete)

            text1.text = todoList[position].task;
            chk.isChecked = todoList[position].checked

            chk.setOnClickListener{
                if(chk.isChecked){
                    text1.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                }
                else{
                    text1.paintFlags = Paint.LINEAR_TEXT_FLAG
                }

            }

            del.setOnClickListener{
                todoList.removeAt(position)
                notifyDataSetChanged()
            }

        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}