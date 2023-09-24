package com.example.jokenpo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpo.databinding.FragmentPlayerBinding
import com.example.jokenpo.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var root : View
    lateinit var resultText : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("LifeCycle", "OnCreateView")
        setHasOptionsMenu(true)
        val  binding = FragmentResultBinding.inflate(inflater, container, false)
        root = binding.root
        resultText = binding.resultFinal

        if(savedInstanceState?.containsKey("resultValue") == true){
            val result = savedInstanceState.getString("resultValue")
            resultText.text = result
        }
        lifecycle.addObserver(CustomObserver())
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
        outState.putString("resultValue", resultText.text.toString())
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
