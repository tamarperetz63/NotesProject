package com.example.mynewandroidproject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.DataBase.AppDataBase
import com.example.tictactoe.DataBase.NotesDao
import com.example.tictactoe.DataBase.NotesData
import com.example.tictactoe.DataBase.getInstanceDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelNotes(private val dao: NotesDao) : ViewModel(){

	fun notesList(): LiveData<List<NotesData>> {
		return dao.getNotesList()
	}

	fun onSaveClicked(userInput: String) {
		viewModelScope.launch(Dispatchers.IO) { dao.insertAll(
				NotesData(
					noteContent = userInput,
					noteDate = "111"
				)
			)

		}
	}

}


