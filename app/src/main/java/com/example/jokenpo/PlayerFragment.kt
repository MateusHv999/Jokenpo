package com.example.jokenpo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpo.databinding.FragmentPlayerBinding


class PlayerFragment : Fragment() {
    lateinit var root : View
    lateinit var spinnerContent: Spinner
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("LifeCycle", "OnCreateView")
        val  binding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = binding.root
        spinnerContent = binding.spinner

        ArrayAdapter.createFromResource(root.context, R.array.play_options, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerContent.adapter = adapter
        }
        if(savedInstanceState?.containsKey("spinnerContentValue") == true){
            val item = savedInstanceState.getInt("spinnerContentValue")
            spinnerContent.setSelection(item)
        }

        setHasOptionsMenu(true)
        return root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.play_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeFragment -> {
                findNavController().navigate(R.id.homeFragment)
            }
            else -> false
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerContentValue", spinnerContent.selectedItemPosition)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("LifeCycle", "onAttach")
    }
    override fun onDetach() {
        super.onDetach()
        Log.d("LifeCycle", "onDetach")
    }
}
