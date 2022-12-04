package com.example.mynewandroidproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.mynewandroidproject.MainActivity
import com.example.mynewandroidproject.NoteData
import com.example.mynewandroidproject.R
import com.example.mynewandroidproject.Session
import com.example.mynewandroidproject.databinding.FragmentHomeBinding

class AddNewNoteFragment : Fragment() {

	private var _binding: FragmentHomeBinding? = null
	var listOfNote: MutableList<NoteData> = mutableListOf()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_home, container, false)
	}

	override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val saveButton = view.findViewById<Button>(R.id.saveButton)
		val textEdit = view.findViewById<EditText>(R.id.text_edit) as EditText


		saveButton.setOnClickListener {
			val userInput = textEdit.text

			Session.notesList.add(NoteData(
				content = userInput,
				date = "111"
			))
			val i = Intent(context, MainActivity::class.java)
			startActivity(i)

		}
	}
}



