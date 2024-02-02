package com.example.taskmanager.holders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.databinding.TaskItemBinding
import com.example.taskmanager.models.Task
import java.text.SimpleDateFormat

class TaskViewHolder(
    parent: ViewGroup,
    private val binding: TaskItemBinding = TaskItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(
    binding.root
) {
    fun bind(task: Task) {
        Log.d("TEST", "bind $task") // не срабатывает
        binding.title.text = task.title
        binding.dateTime.text = task.dateTime.toString() // TODO придумать чета с форматом

        binding.show.setOnClickListener {
            // TODO
        }
    }
}