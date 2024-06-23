package com.example.myapplication222

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        layout = findViewById(R.id.layout)
        button2.visibility = View.GONE
        button1.setOnClickListener {
          
            button2.visibility = View.VISIBLE
        }

        button2.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> true
                MotionEvent.ACTION_MOVE -> {
                    view.y = event.rawY - view.height / 2
                    view.x = event.rawX - view.width / 2
                    true
                }
                else -> false
            }
        }
    }
}

