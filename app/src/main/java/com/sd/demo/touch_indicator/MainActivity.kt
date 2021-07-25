package com.sd.demo.touch_indicator

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sd.demo.touch_indicator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.viewTouchIndicator.setIndexChangeCallback { index, view ->
            Log.i(TAG, "onIndexChanged ${index}")
            val text = if (view is TextView) view.text.toString() else ""
            if (view != null) {
                _binding.viewTouchIndicator.setBackgroundColor(Color.parseColor("#EEEEEE"))
                _binding.tvText.apply {
                    this.text = text
                    this.visibility = View.VISIBLE
                }
            } else {
                _binding.viewTouchIndicator.setBackgroundColor(Color.TRANSPARENT)
                _binding.tvText.apply {
                    this.text = ""
                    this.visibility = View.GONE
                }
            }
        }
    }
}