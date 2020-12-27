package com.example.userkotlin.ui.slideshow

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.userkotlin.R
import java.util.*

class TimePickerFragment(val listener: (String) -> Unit) : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(
            activity as Context,
            R.style.pickDataTECNMTheme,
            this,
            hour,
            minute,
            false
        )
        return dialog
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        var status = "AM"

        if (hourOfDay > 11) {
            // If the hour is greater than or equal to 12
            // Then the current AM PM status is PM
            status = "PM"
        }

//

        listener("$hourOfDay:$minute $status")
    }

}