package com.example.fragmentstutorial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fragmentstutorial.R
import com.example.fragmentstutorial.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)


//        binding.play.setOnClickListener {
//            it.findNavController().navigate(R.id.action_homeFragment2_to_quizFragment)
//        }

        binding.play.setOnClickListener { v:View ->
            v.findNavController().navigate(R.id.action_homeFragment2_to_quizFragment)
        }

        return binding.root
    }
}