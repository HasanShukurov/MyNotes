package com.hasanshukurov.toolbarnumune.ui.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.hasanshukurov.toolbarnumune.repo.NoteRepository
import com.hasanshukurov.toolbarnumune.ui.fragment.DetailsFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val noteRepo: NoteRepository) : ViewModel() {

    fun saveNoteVM(title: String, note: String) {
        noteRepo.saveNoteRepo(title,note)
    }

}