package com.example.taskmanager.services

import com.example.taskmanager.models.Task
import java.util.Calendar
import java.util.Date
import java.util.Random

class TaskRepository {

    public fun getTasks(): List<Task> {
        return (1..5).map {
            Task(
                title = "Задача $it",
                description = "Описание $it",
                dateTime = generateRandomDateFromBeginToMaxDay(Calendar.getInstance().time, 100)
            )
        }
    }

    private fun generateRandomDateFromBeginToMaxDay(begin: Date, maxDate: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = begin
        val random = Random().nextInt(maxDate) + 1
        calendar.add(Calendar.DAY_OF_MONTH, random)

        return calendar.time
    }
}