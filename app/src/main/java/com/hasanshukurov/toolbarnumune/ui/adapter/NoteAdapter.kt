package com.hasanshukurov.toolbarnumune.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hasanshukurov.toolbarnumune.R
import com.hasanshukurov.toolbarnumune.databinding.NoteRowBinding
import com.hasanshukurov.toolbarnumune.model.NotesModel
import com.hasanshukurov.toolbarnumune.ui.fragment.HomeFragmentDirections
import com.hasanshukurov.toolbarnumune.ui.viewmodel.HomeViewModel

class NoteAdapter(val noteList: List<NotesModel>,
                  var viewModel: HomeViewModel
                  ) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    class NoteHolder(val binding: NoteRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val binding: NoteRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.note_row,
            parent,
            false
        )
        return NoteHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.binding.recyclerObject = noteList[position]

        holder.binding.noteRowTextView.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.fromHomeToReplace(noteArgs = noteList[position]))
        }

        holder.binding.ImageView.setOnClickListener {

            val alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Delete Note")
            alert.setMessage("Are You Sure Delete The Note ?")
            alert.setPositiveButton("Yes"){dialog, which ->
                viewModel.deleteNoteVM(noteList[position].id!!)
                Toast.makeText(holder.itemView.context, "${noteList[position].title} -> Silindi",Toast.LENGTH_LONG).show()
            }
            alert.setNegativeButton("No"){dialog,which ->
                return@setNegativeButton
            }
            alert.show()


    /*
            Snackbar.make(it, "Are you shure delete ?", Snackbar.LENGTH_LONG).setAction("Yes"){
                viewModel.deleteNoteVM(noteList[position].id)
                Toast.makeText(holder.itemView.context, "${noteList[position].title} -> Silindi",Toast.LENGTH_LONG).show()
            }.show()

     */
        }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}