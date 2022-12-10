package com.example.mynewandroidproject.dataSource

import android.content.Context
import com.example.mynewandroidproject.domain.NoteDataRepository
import com.example.tictactoe.DataBase.NotesData
import com.example.tictactoe.DataBase.getInstanceDB

open class NotesRepository : NoteDataRepository {

	override suspend fun insertNotes(context: Context, content: String, date: String) {
		getInstanceDB.getInstance(context).getNotesDao().insertAll(
			NotesData(
				noteDate = date,
				noteContent = content,
			)
		)
	}

	override fun getNotesList(context: Context) {
		getInstanceDB.getInstance(context).getNotesDao()
	}
}