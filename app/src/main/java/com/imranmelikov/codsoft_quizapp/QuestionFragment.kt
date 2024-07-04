package com.imranmelikov.codsoft_quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.imranmelikov.codsoft_quizapp.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private lateinit var binding:FragmentQuestionBinding
    private var position=1
    private var score=0
    private var questionCount=0
    private var checkAnswer=false
    private var textClick=true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentQuestionBinding.inflate(inflater,container,false)


        newQuestions()
        submitQuestions()
        return binding.root
    }

    private fun newQuestions(){
        val questions=Constants.getQuestions()
        val question=questions[questionCount]
        binding.ivQuestion.setImageResource(question.image)
        binding.tvQuestion.text=question.question
        binding.tvOptionOne.text=question.answer1
        binding.tvOptionTwo.text=question.answer2
        binding.tvOptionThree.text=question.answer3
        binding.tvOptionFour.text=question.answer4
        binding.tvProgress.text=score.toString()
        binding.progressBar.progress=score
    }

    private fun submitQuestions(){

        val textList= mutableListOf(binding.tvOptionOne,binding.tvOptionTwo,binding.tvOptionThree,binding.tvOptionFour)

            textList.map {answer->
                    answer.setOnClickListener {
                        if (textClick){
                            textClick=false
                            val response= Constants.answer(answer.text.toString(),position)
                            if (response){
                                answer.background = ContextCompat.getDrawable(requireContext(),R.drawable.selected_option_border_color)
                                score+=1
                            }else{
                                answer.background = ContextCompat.getDrawable(requireContext(),R.drawable.wrong_option_border_color)
                            }
                            checkAnswer=true
                            newQuestions()
                        }
                    }
            }
        binding.btnSubmit.setOnClickListener {
            if (checkAnswer){
                textList.map {
                    it.background = ContextCompat.getDrawable(requireContext(),R.drawable.default_option_border_bg)
                    it.isEnabled=true
                }
                when (questionCount) {
                    4 -> {
                        val bundle=Bundle()
                        bundle.putInt("score",score)
                        findNavController().navigate(R.id.action_questionFragment_to_resultFragment,bundle)
                    }
                    3 -> {
                        binding.btnSubmit.text="GO TO NEXT"
                        questionCount+=1
                        position+=1
                    }
                    else -> {
                        questionCount+=1
                        position+=1
                    }
                }
                checkAnswer=false
                textClick=true
            }else{
                Toast.makeText(requireContext(),"Choose Answer",Toast.LENGTH_SHORT).show()
            }
            newQuestions()
        }
    }
}