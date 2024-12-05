package com.example.sum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels


class Sum : Fragment() {

    private val vm: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val x = view.findViewById<EditText>(R.id.first_number)
        val y = view.findViewById<EditText>(R.id.second_number)
        val sum = view.findViewById<Button>(R.id.sum_button)

        sum.setOnClickListener { vm.setSum(x.text.toString().toInt(), y.text.toString().toInt()) }
    }


}