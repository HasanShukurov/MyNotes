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
import androidx.navigation.fragment.navArgs
import com.hasanshukurov.toolbarnumune.R
import com.hasanshukurov.toolbarnumune.databinding.FragmentReplaceBinding
import com.hasanshukurov.toolbarnumune.ui.viewmodel.ReplaceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReplaceFragment : Fragment() {

    private lateinit var binding: FragmentReplaceBinding
    private lateinit var viewModel: ReplaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val x : ReplaceViewModel by viewModels()
        viewModel = x
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_replace, container, false)
        binding.replaceFragmentXml = this@ReplaceFragment

        binding.replaceToolbarTitleXml = "Replace Note"

        val bundle: ReplaceFragmentArgs by navArgs()
        val gelenArgs = bundle.noteArgs

        binding.replaceObject = gelenArgs





        return binding.root
    }


    fun replaceButton(id: Int, title: String, note: String,it:View){
        viewModel.replaceNoteVM(id,title,note)

        Navigation.findNavController(it).navigate(ReplaceFragmentDirections.fromReplaceToHome())
    }

}