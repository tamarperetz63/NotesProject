package com.example.mynewandroidproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewandroidproject.ui.home.AddNewNoteFragment

class AdapterNotes() : RecyclerView.Adapter<AdapterNotes.ViewHolder>() {
	interface OnItemClickListener {
//		fun onItemAcceptClick(position: Int)
//		fun onItemDetailsClick(position: Int)
	}

	private lateinit var listener: OnItemClickListener

	fun setOnItemClickListener(listener: OnItemClickListener) {
		this.listener = listener
	}

	var notesList: List<NoteData> = emptyList()
		@SuppressLint("NotifyDataSetChanged")
		set(value) {
			field = value
			notifyDataSetChanged()
		}


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.notes, parent, false)
		return ViewHolder(view)
	}

	@SuppressLint("SetTextI18n")
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val note = notesList[position]

		holder.apply {
			cardContent.text = note.content
			cardDate.text = note.date.toString()
		}
	}

	override fun getItemCount(): Int {
		return notesList.size
	}

	fun setOnItemClickListener(homeFragment: AddNewNoteFragment) {

	}


	class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
		val cardContent: TextView = itemView.findViewById(R.id.noteContet)
		val cardDate: TextView = itemView.findViewById(R.id.notrDate)
	}

}


