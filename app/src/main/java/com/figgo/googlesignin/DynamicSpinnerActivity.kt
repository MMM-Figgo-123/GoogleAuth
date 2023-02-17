package com.figgo.googlesignin

import android.R
import android.R.string
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.figgo.googlesignin.databinding.ActivityDynamicSpinnerBinding


class DynamicSpinnerActivity : AppCompatActivity() {

    lateinit var binding: ActivityDynamicSpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicSpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var spinner = binding.spinner.spinner

        val arrayListSubjects: ArrayList<String> = ArrayList()
        arrayListSubjects.add("JAVA")
        arrayListSubjects.add("ANDROID")
        arrayListSubjects.add("C Language")
        arrayListSubjects.add("CPP Language")
        arrayListSubjects.add("Go Language")
        arrayListSubjects.add("AVN SYSTEMS")
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, arrayListSubjects)
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View?, position: Int, id: Long
            ) {
                val tutorialsName: String = parent.adapter.getItem(position).toString()
                Toast.makeText(parent.context, "Selected: $tutorialsName", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }


}