package com.example.mynewandroidproject.dataSource

import androidx.lifecycle.LiveData
import com.example.mynewandroidproject.domain.NoteDataRepository
import com.example.tictactoe.DataBase.NotesDao
import com.example.tictactoe.DataBase.NotesData
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

	override fun getNoteFromRemote() {
		val retrofit = Retrofit.Builder()
			.client(
				OkHttpClient.Builder()
					.followRedirects(true).followSslRedirects(true).build()
			)
			.baseUrl("https://69eee55b-f7a2-4b3a-9540-9ebffdb1e5d7.mock.pstmn.io/getNoteList")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
//		val suggestMovesAPI: SuggestMovesAPI = retrofit.create(SuggestMovesAPI::class.java)

	}
}