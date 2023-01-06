package com.example.fragmentstutorial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fragmentstutorial.R
import com.example.fragmentstutorial.databinding.FragmentQuizWinBinding

class QuizWinFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentQuizWinBinding>(inflater, R.layout.fragment_quiz_win, container, false)

        binding.retake.setOnClickListener { v:View ->
            v.findNavController().navigate(R.id.action_quizWinFragment_to_quizFragment)
        }

        return binding.root
    }
}