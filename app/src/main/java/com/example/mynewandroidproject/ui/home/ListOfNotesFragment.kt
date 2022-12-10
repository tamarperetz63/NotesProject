package com.example.mynewandroidproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewandroidproject.AdapterNotes
import com.example.mynewandroidproject.NoteData
import com.example.mynewandroidproject.R
import com.example.mynewandroidproject.Session


class ListOfNotesFragment : Fragment() {
	lateinit var listOfNotes: MutableList<NoteData>
	val adapter = AdapterNotes()


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


	}

	companion object {

		fun newInstance(param1: String, param2: String) =
			ListOfNotesFragment().apply {
				arguments = Bundle().apply {
				}
			}
	}
}