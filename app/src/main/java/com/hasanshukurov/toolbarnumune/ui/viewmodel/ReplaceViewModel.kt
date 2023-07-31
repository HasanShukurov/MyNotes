package com.hasanshukurov.toolbarnumune.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.toolbarnumune.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReplaceViewModel @Inject constructor(val noteRepo: NoteRepository) : ViewModel() {

    fun replaceNoteVM(id: Int, title: String, note: String){
        viewModelScope.launch {
            noteRepo.replaceNoteRepo(id,title,note)
        }
    }
}