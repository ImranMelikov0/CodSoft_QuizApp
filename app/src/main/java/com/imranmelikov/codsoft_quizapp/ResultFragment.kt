package com.imranmelikov.codsoft_quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.imranmelikov.codsoft_quizapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentResultBinding.inflate(inflater,container,false)

        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_firstFragment)
        }

        val result=arguments?.getInt("score")
        binding.tvScore.text="Your score is $result"
        return binding.root
    }
}