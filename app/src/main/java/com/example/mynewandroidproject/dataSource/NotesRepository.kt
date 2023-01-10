package com.example.mynewandroidproject.dataSource

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mynewandroidproject.domain.NoteDataRepository
import com.example.tictactoe.DataBase.NotesDao
import com.example.tictactoe.DataBase.NotesData
import com.example.tictactoe.DataBase.getInstanceDB

class NotesRepository(private val dao: NotesDao) : NoteDataRepository {

	override suspend fun insertNotes(content: String, date: String) {
		dao.insertAll(
			NotesData(
				noteDate = date,
				noteContent = content,
			)
		)
	}
	override fun getNotesList(): LiveData<List<NotesData>> {
		return dao.getNotesList()
	}
}