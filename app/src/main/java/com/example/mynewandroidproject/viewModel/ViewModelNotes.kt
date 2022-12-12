package com.example.mynewandroidproject.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tictactoe.DataBase.NotesData
import com.example.tictactoe.DataBase.getInstanceDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelNotes : ViewModel() {


		fun notesList(context: Context): LiveData<List<NotesData>> {
			return getInstanceDB.getInstance(context).getNotesDao().getNotesList()
		}

		fun onSaveClicked(userInput: String, context: Context) {
			viewModelScope.launch(Dispatchers.IO) {
				getInstanceDB.getInstance(context).getNotesDao().insertAll(
					NotesData(
						noteContent = userInput,
						noteDate = "111"
					)
				)

			}
		}

}


