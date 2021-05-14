package com.example.myunittesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myunittesting.testing.TestActivity
import com.example.myunittesting.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_test.setOnClickListener(this)
        btn_view_model.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_test -> {
                val testIntent = Intent(this, TestActivity::class.java)
                startActivity(testIntent)
            }
            R.id.btn_view_model -> {
                Toast.makeText(this, "View Model", Toast.LENGTH_LONG).show()
                val viewModelIntent = Intent(this, ViewModelActivity::class.java)
                startActivity(viewModelIntent)
            }
        }
    }
}