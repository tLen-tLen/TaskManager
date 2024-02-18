package com.example.taskmanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskmanager.databinding.AddTaskBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: AddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDateTimeListener()
    }

    private fun setDateTimeListener() {
        val cal = Calendar.getInstance()

        binding.dateTime.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    TimePickerDialog(
                        this, { _, hour, minute ->
                            cal.set(Calendar.HOUR, hour)
                            cal.set(Calendar.MINUTE, minute)

                            val sdf = SimpleDateFormat("dd.MM.yyyy hh:mm", Locale.US)
                            binding.dateTime.setText(sdf.format(cal.time))
                        },
                        0, 0, false
                    ).show()
                },
                2023, 12, 12
            ).show()
        }
    }
}