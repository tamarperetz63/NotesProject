package com.example.mynewandroidproject.domain

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.tictactoe.DataBase.NotesData

interface NoteDataRepository {

	suspend fun insertNotes(content: String, date: String)

	fun getNotesList() : LiveData<List<NotesData>>

	fun getNoteFromRemote()
}

