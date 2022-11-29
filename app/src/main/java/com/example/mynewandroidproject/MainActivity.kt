package com.example.mynewandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val welcomeButtonId = findViewById<Button>(R.id.welcomeButtonId)

		welcomeButtonId.setOnClickListener {
			val i = Intent(this@MainActivity, SecondeActivity::class.java)
			startActivity(i)
		}

	}
}