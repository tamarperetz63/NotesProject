package com.example.mynewandroidproject.domain

import android.content.Context

interface NoteDataRepository {

	suspend fun insertNotes(
		context: Context, content: String, date: String
	)
	fun getNotesList(context: Context)
}