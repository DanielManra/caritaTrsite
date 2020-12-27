package com.example.userkotlin.ui.slideshow

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.userkotlin.R
import java.util.*

class DatePickerFragment(val lisener: (day: Int, mont: Int, year: Int) -> Unit):DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        lisener(dayOfMonth,month,year)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,R.style.pickDataTECNMTheme, this, year, month, day)
        picker.datePicker.minDate = c.timeInMillis
        return picker
    }

}