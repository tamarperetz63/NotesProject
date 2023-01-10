package com.example.mynewandroidproject.di

import com.example.mynewandroidproject.dataSource.NotesRepository
import com.example.mynewandroidproject.domain.NoteDataRepository
import com.example.mynewandroidproject.viewModel.ViewModelNotes
import com.example.tictactoe.DataBase.getInstanceDB
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

	single {
		getInstanceDB.getInstance(get()).getNotesDao()
	}

	single<NoteDataRepository> {
		NotesRepository(dao = get())
	}

	viewModel {
		ViewModelNotes(dao = get())
	}
}