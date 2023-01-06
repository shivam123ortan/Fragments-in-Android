package com.example.fragmentstutorial.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fragmentstutorial.R
import com.example.fragmentstutorial.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is android Jetpack?",
            answers = listOf("All of these", "Tools", "Documentation", "Libraries")
        ),
        Question(
            text = "What is the base class for layouts?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "What layout do you use for complex screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "What do you use to push structured data into a layout?",
            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")
        ),
        Question(
            text = "What method do you use to inflate layouts in fragments?",
            answers = listOf(
                "onCreateView()",
                "onActivityCreated()",
                "onCreateLayout()",
                "onInflateLayout()"
            )
        ),
        Question(
            text = "What's the build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Which class do you use to create a vector drawable?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Question(
            text = "Which one of these is an Android navigation component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Which XML element lets you register an activity with the launcher activity?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "What do you use to mark a layout for data binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )

    lateinit var currentQuestion: Question
    lateinit var answer: MutableList<String>
    private var questionIndex = 0
    private var totalQuestion = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(inflater, R.layout.fragment_quiz, container, false)

        binding.questions = this

        randomizeQuestion()

        binding.submitBtn.setOnClickListener { v:View ->
            val checkId = binding.radioGroup.checkedRadioButtonId
            if (checkId != -1){
                var answerIndex = 0

                when(checkId){
                    R.id.answerSecond -> answerIndex = 1
                    R.id.answerThird -> answerIndex = 2
                    R.id.answerForth -> answerIndex = 3
                }

                if (answer[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    if (questionIndex<totalQuestion){
                        currentQuestion = questions[questionIndex]
                        setQuestion()

                        binding.invalidateAll()
                    } else {
                        run {
                            this.findNavController().navigate(R.id.action_quizFragment_to_quizWinFragment)
                        }
                    }

                } else {
                    run {
                        this.findNavController().navigate(R.id.action_quizFragment_to_quizOverFragment)
                    }
                }
            }
        }

        return binding.root
    }

    private fun randomizeQuestion() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answer = currentQuestion.answers.toMutableList()
        answer.shuffle()
    }
}