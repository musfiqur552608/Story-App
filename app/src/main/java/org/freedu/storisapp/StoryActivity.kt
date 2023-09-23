package org.freedu.storisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.freedu.storisapp.databinding.ActivityMainBinding
import org.freedu.storisapp.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStoryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.title.text = intent.getStringExtra("title")
        binding.details.text = intent.getStringExtra("details")
        binding.img.setImageResource(intent.getIntExtra("img", 0))
    }
}