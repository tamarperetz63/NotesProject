package com.example.mynewandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
	lateinit var listOfNotes: MutableList<NoteData>
	val adapter = AdapterNotes()

	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val addNoteButtonId = findViewById<Button>(R.id.welcomeButtonId)
		val notesCards = findViewById<View>(R.id.recyclerView) as RecyclerView

		notesCards.adapter = adapter
		notesCards.layoutManager = LinearLayoutManager(this)

		adapter.notesList


		addNoteButtonId.setOnClickListener {
			val i = Intent(this@MainActivity, SecondeActivity::class.java)
			startActivity(i)
		}

	}
}