package com.hasanshukurov.toolbarnumune.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.toolbarnumune.model.NotesModel
import com.hasanshukurov.toolbarnumune.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val noteRepo: NoteRepository) : ViewModel() {
    var noteList = MutableLiveData<List<NotesModel>>()

    fun searchNoteVM(searchText:String){
        viewModelScope.launch {
            noteList.value = noteRepo.searchNoteRepo(searchText)
        }

    }

    fun deleteNoteVM(noteId: Int){
        viewModelScope.launch {
            noteRepo.deleteNoteRepo(noteId)

            getAllNotesVM()
        }
    }

    fun getAllNotesVM(){
        viewModelScope.launch {
            noteList.value = noteRepo.getAllNotesRepo()
        }
    }

}