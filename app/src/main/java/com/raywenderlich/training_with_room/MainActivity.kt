package com.raywenderlich.training_with_room

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.training_with_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}