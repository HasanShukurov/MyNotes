package com.hasanshukurov.toolbarnumune.repo

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.hasanshukurov.toolbarnumune.model.NotesModel
import com.hasanshukurov.toolbarnumune.room.NoteDao
import com.hasanshukurov.toolbarnumune.ui.fragment.DetailsFragmentDirections
import com.hasanshukurov.toolbarnumune.ui.fragment.ReplaceFragmentDirections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteRepository @Inject constructor(val noteDao: NoteDao) {
    private var job : Job? = null

    fun saveNoteRepo(title: String, note: String){

        job = CoroutineScope(Dispatchers.Main).launch {

            val newNote = NotesModel(title,note)

            noteDao.addNote(newNote)

        }

    }

    suspend fun replaceNoteRepo(id: Int, title: String, note: String){
        val replaceNote = NotesModel(title,note,id)
        noteDao.replaceNote(replaceNote)

        getAllNotesRepo()

    }

    suspend fun searchNoteRepo(searchNoteText:String) : List<NotesModel>{
        return noteDao.searchNote(searchNoteText)
    }

    suspend fun deleteNoteRepo(noteId: Int){
            val deletedNote = NotesModel("","",noteId)
            noteDao.deleteNote(deletedNote)

            getAllNotesRepo()
    }


    suspend fun getAllNotesRepo(): List<NotesModel> {
        return noteDao.allNotes()
    }
}