package com.example.mynewandroidproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

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