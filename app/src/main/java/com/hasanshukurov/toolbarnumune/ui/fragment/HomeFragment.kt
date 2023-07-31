package com.hasanshukurov.toolbarnumune.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.hasanshukurov.toolbarnumune.R
import com.hasanshukurov.toolbarnumune.ui.adapter.NoteAdapter
import com.hasanshukurov.toolbarnumune.databinding.FragmentHomeBinding
import com.hasanshukurov.toolbarnumune.model.NotesModel
import com.hasanshukurov.toolbarnumune.repo.NoteRepository
import com.hasanshukurov.toolbarnumune.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x : HomeViewModel by viewModels()
        viewModel = x
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homeFragmentXml = this@HomeFragment

        binding.homeToolbarTitleXml = "My All Notes"



        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHome)

        requireActivity().addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.serach_menu,menu)
                val item = menu.findItem(R.id.search_Id)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        viewModel.noteList.observe(viewLifecycleOwner){
            val adapter = NoteAdapter(it,viewModel)
            binding.homeObject = adapter
        }



    viewModel.getAllNotesVM()



        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchNoteVM(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchNoteVM(newText)
        return true
    }


    fun fabOnClick(){
        findNavController().navigate(HomeFragmentDirections.fromHomeToDetail())
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNotesVM()
    }

}