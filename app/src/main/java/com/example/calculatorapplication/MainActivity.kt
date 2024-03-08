package com.example.calculatorapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val views = binding.root
        setContentView(views)

        binding.linearLayoutCalculator.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, LinearFragment(), LinearFragment.TAG)
                .addToBackStack(null)
                .commit()
        }

        binding.frameLayoutCalculator.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, FrameFragment(), FrameFragment.TAG)
                .addToBackStack(null)
                .commit()
        }

        binding.constraintLayoutCalculator.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, FrameFragment(), FrameFragment.TAG)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}