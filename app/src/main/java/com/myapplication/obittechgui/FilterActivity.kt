package com.myapplication.obittechgui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.*
import java.util.*

class FilterActivity : AppCompatActivity() {

    lateinit var dateEdt:EditText
    lateinit var dateEdtt:EditText
    lateinit var filter_back_arrow:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        findView()
        onClickListner()
        onBackPress()

        val category=resources.getStringArray(R.array.Categories)
        val spinner=findViewById<Spinner>(R.id.spinner)

            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, category)
            spinner.adapter = adapter
            spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long) {

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }


            }


    }

    private fun findView()
    {
        dateEdt=findViewById(R.id.idDate1)
        dateEdtt=findViewById(R.id.idDate2)
        filter_back_arrow=findViewById(R.id.filter_backicon)
    }

    private fun onClickListner()
    {
        dateEdt.setOnClickListener {

            val c = Calendar.getInstance()

            val year=c.get(Calendar.YEAR)
            val month=c.get(Calendar.MONTH)
            val day=c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog= DatePickerDialog(
                this,
                { view, year, monthofYear, dayofMonth ->
                    val dat = (dayofMonth.toString() + "-" + (monthofYear + 1) + "-" + year)
                    dateEdt.setText(dat)
                },

                year,
                month,
                day
            )

            datePickerDialog.show()

        }

        dateEdtt.setOnClickListener {

            val cl = Calendar.getInstance()

            val year=cl.get(Calendar.YEAR)
            val month=cl.get(Calendar.MONTH)
            val day=cl.get(Calendar.DAY_OF_MONTH)


            val datePickerDialogg= DatePickerDialog(
                this,
                { view, year, monthofYear, dayofMonth ->
                    val datt = (dayofMonth.toString() + "-" + (monthofYear + 1) + "-" + year)
                    dateEdtt.setText(datt)
                },

                year,
                month,
                day
            )

            datePickerDialogg.show()

        }


    }

    private fun onBackPress()
    {
        filter_back_arrow.setOnClickListener {
            onBackPressed()
        }
    }
}