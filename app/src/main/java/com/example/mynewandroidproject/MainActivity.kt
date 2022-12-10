package com.example.mynewandroidproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	lateinit var listOfNotes: MutableList<NoteData>
	val adapter = AdapterNotes()

	@SuppressLint("MissingInflatedId")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

//first fragment
//	override fun onResume() {
//		super.onResume()
//		adapter.notesList = Session.notesList
//		adapter.notifyDataSetChanged()
//	}
	}
}