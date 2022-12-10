package com.example.mynewandroidproject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tictactoe.DataBase.NotesData
import com.example.tictactoe.DataBase.getInstanceDB

class viewModelNotes : ViewModel() {

	fun notesList(context: Context): LiveData<List<NotesData>> {
		return getInstanceDB.getInstance(context).getNotesDao().getNotesList()
	}



}