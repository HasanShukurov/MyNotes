package com.hasanshukurov.toolbarnumune.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.hasanshukurov.toolbarnumune.R
import com.hasanshukurov.toolbarnumune.databinding.FragmentDetailsBinding
import com.hasanshukurov.toolbarnumune.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x : DetailViewModel by viewModels()
        viewModel = x
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container, false)
        binding.detailsFragmentXml = this@DetailsFragment

        binding.detailsToolbarTitleXml = "New Note"







        return binding.root
    }

    fun saveButton(title: String, note: String, it: View){
        viewModel.saveNoteVM(title,note)

        Navigation.findNavController(it).navigate(DetailsFragmentDirections.fromDetailToHome())
    }

}