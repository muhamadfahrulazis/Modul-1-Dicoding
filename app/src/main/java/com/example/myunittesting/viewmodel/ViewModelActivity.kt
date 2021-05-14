package com.example.myunittesting.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myunittesting.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {

//    private lateinit var viewModel: MainViewModel

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        btn_calculate.setOnClickListener(this)
    }

    private fun displayResult() {
        tv_result.text = viewModel.result.toString()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_calculate -> {
                val width = edt_width.text.toString()
                val length = edt_length.text.toString()
                val height = edt_height.text.toString()

                when{
                    width.isEmpty() -> {
                        edt_width.error = "Masih kosong"
                    }
                    length.isEmpty() -> {
                        edt_length.error = "Masih kosong"
                    }
                    height.isEmpty() -> {
                        edt_height.error = "Masih kosong"
                    }
                    else -> {
                        viewModel.calculate(width, length, height)
                        displayResult()
                    }
                }
            }
        }
    }
}