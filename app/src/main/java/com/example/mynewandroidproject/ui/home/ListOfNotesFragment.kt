package com.example.mynewandroidproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewandroidproject.AdapterNotes
import com.example.mynewandroidproject.NoteData
import com.example.mynewandroidproject.R
import com.example.mynewandroidproject.Session
import com.example.mynewandroidproject.viewModel.ViewModelNotes
import com.example.tictactoe.DataBase.NotesData
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ListOfNotesFragment : Fragment(), KoinComponent {
	lateinit var listOfNotes: MutableList<NoteData>
	val adapter = AdapterNotes()
	private val viewModelNotes: ViewModelNotes by inject()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_list_of_notes, container, false)
	}

	override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val addNoteButtonId = view.findViewById<Button>(R.id.welcomeButtonId)
		val notesCards = view.findViewById<View>(R.id.recyclerView) as RecyclerView

		adapter.notesList = Session.notesList
		notesCards.adapter = adapter
		notesCards.layoutManager = LinearLayoutManager(context)

		addNoteButtonId.setOnClickListener {
			findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_home)
		}
		viewModelNotes.notesList().observe(viewLifecycleOwner) { noteData: List<NotesData>? ->
			var noteList: MutableList<NoteData> = mutableListOf()
			if (noteData == null) {
				return@observe
			}

			for (note in noteData) {
				noteList.add(
					NoteData(
						note.noteContent, note.noteDate
					)
				)
			}
			adapter.notesList = noteList
		}

	}

	companion object {

		fun newInstance(param1: String, param2: String) =
			ListOfNotesFragment().apply {
				arguments = Bundle().apply {
				}
			}
	}
}