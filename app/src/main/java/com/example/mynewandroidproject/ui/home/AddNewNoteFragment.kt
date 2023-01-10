package com.example.mynewandroidproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mynewandroidproject.NoteData
import com.example.mynewandroidproject.R
import com.example.mynewandroidproject.viewModel.ViewModelNotes
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddNewNoteFragment : Fragment(),KoinComponent {

	var listOfNote: MutableList<NoteData> = mutableListOf()
	private val viewModelNotes: ViewModelNotes by viewModel()

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
			val userInput = textEdit.text.toString()
			viewModelNotes.onSaveClicked(userInput)
			findNavController().popBackStack()
		}
	}
}




