package com.example.myunittesting.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.example.myunittesting.R
import com.example.myunittesting.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        mainViewModel = MainViewModel(CuboidModel())
        btn_save.setOnClickListener(this)
        btn_calculate_circumference.setOnClickListener(this)
        btn_calculate_surface_area.setOnClickListener(this)
        btn_calculate_volume.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val length = edt_length.text.toString().trim()
        val width = edt_width.text.toString().trim()
        val height = edt_height.text.toString().trim()

        when{
            TextUtils.isEmpty(length)->{
                edt_length.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(width)->{
                edt_width.error = "Field ini tidak boleh kosong"
            }
            TextUtils.isEmpty(height)->{
                edt_height.error = "Field ini tidak boleh kosong"
            }

            else -> {
                val valueLength = length.toDouble()
                val valueWidth = width.toDouble()
                val valueHeight = height.toDouble()

                when(v?.id){
                    R.id.btn_save -> {
                        mainViewModel.save(valueWidth, valueLength, valueHeight)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        tv_result.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        tv_result.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        tv_result.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun gone() {
        btn_calculate_volume.visibility = View.GONE
        btn_calculate_surface_area.visibility = View.GONE
        btn_calculate_circumference.visibility = View.GONE
        btn_save.visibility = View.VISIBLE
    }

    private fun visible() {
        btn_calculate_volume.visibility = View.VISIBLE
        btn_calculate_surface_area.visibility = View.VISIBLE
        btn_calculate_circumference.visibility = View.VISIBLE
        btn_save.visibility = View.GONE
    }
}