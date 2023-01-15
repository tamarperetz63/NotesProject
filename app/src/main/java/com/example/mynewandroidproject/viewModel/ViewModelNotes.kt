package com.example.mynewandroidproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewandroidproject.dataSource.NotesRepository
import com.example.mynewandroidproject.domain.NoteDataRepository
import com.example.tictactoe.DataBase.NotesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelNotes(private val repo: NoteDataRepository) : ViewModel() {

	fun notesList(): LiveData<List<NotesData>> {
		return repo.getNotesList()
	}

	fun onSaveClicked(userInput: String) {
		viewModelScope.launch(Dispatchers.IO) {
			repo.insertNotes(
				userInput,
				"111"

			)
		}
	}

}


