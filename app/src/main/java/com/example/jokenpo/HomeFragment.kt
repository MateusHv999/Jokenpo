package com.example.jokenpo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jokenpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.d("LifeCycle", "onCreateView")
        binding.startBtn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNavigation()
            findNavController().navigate(action)
        }
        lifecycle.addObserver(CustomObserver())

        return binding.root
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

