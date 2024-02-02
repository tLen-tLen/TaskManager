package com.example.taskmanager.adapters

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.holders.TaskViewHolder
import com.example.taskmanager.models.Task

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>()  {

    private var items: List<Task> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Log.d("TEST", "onBindViewHolder ${items[position]}")
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(newItems: List<Task>) {

        val oldItems = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return oldItems.size
            }

            override fun getNewListSize(): Int {
                return newItems.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldItems[oldItemPosition].id == newItems[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldItems[oldItemPosition] == newItems[newItemPosition]
            }

        })

        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}