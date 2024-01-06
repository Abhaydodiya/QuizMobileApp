package com.adk.quizmobileapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.adk.quizmobileapp.Controller.QuestionController

class QuizQuestionsActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var tvProgressText: TextView
    lateinit var tvQuestion: TextView
    lateinit var tvOptionA: TextView
    lateinit var tvOptionB: TextView
    lateinit var tvOptionC: TextView
    lateinit var tvOptionD: TextView
    lateinit var imgQuestion: ImageView
    lateinit var btnSubmit: Button
    private var questionList: ArrayList<Question> = ArrayList<Question>();
    private var currentPosition = 1;
    private var selectedOption = 0;
    private var btnClickDone = false
    private var rightAns = 5;
    private var score = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgressText = findViewById(R.id.tvProgressBar)
        tvQuestion = findViewById(R.id.question)
        tvOptionA = findViewById(R.id.option1)
        tvOptionB = findViewById(R.id.option2)
        tvOptionC = findViewById(R.id.option3)
        tvOptionD = findViewById(R.id.option4)
        imgQuestion = findViewById(R.id.image)
        btnSubmit = findViewById(R.id.btnSubmit)

        val getIntent: Intent = intent
        val s = getIntent.getStringExtra("userName").toString()


        questionList = QuestionController.getQuestion()

        setQuestion()

        tvOptionA.setOnClickListener {
            if (!btnClickDone) {
                selectedOption = 1
                selectedColorSet(tvOptionA)
                defaultColorSet(tvOptionB)
                defaultColorSet(tvOptionC)
                defaultColorSet(tvOptionD)
            }

        }
        tvOptionB.setOnClickListener {
            if (!btnClickDone) {
                selectedOption = 2
                selectedColorSet(tvOptionB)
                defaultColorSet(tvOptionA)
                defaultColorSet(tvOptionC)
                defaultColorSet(tvOptionD)
            }

        }
        tvOptionC.setOnClickListener {
            if (!btnClickDone) {
                selectedOption = 3
                selectedColorSet(tvOptionC)
                defaultColorSet(tvOptionA)
                defaultColorSet(tvOptionB)
                defaultColorSet(tvOptionD)

            }
        }
        tvOptionD.setOnClickListener {
            if (!btnClickDone) {
                selectedOption = 4
                selectedColorSet(tvOptionD)
                defaultColorSet(tvOptionA)
                defaultColorSet(tvOptionB)
                defaultColorSet(tvOptionC)
            }

        }
        btnSubmit.setOnClickListener() {
            if (btnClickDone) {
                defaultColorSet(tvOptionA)
                defaultColorSet(tvOptionB)
                defaultColorSet(tvOptionC)
                defaultColorSet(tvOptionD)

                if (currentPosition > questionList.size) {
                    val intent: Intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("userName",s )
                    intent.putExtra("result", "Your score is $score out of ${questionList.size}.")
                    startActivity(intent)
                    finish()
                }else{
                    setQuestion()
                }
                btnClickDone = false
            } else {
                currentPosition++;
                if (rightAns == selectedOption) {
                    score++
                    setRightAnsBg(selectedOption)

                } else {
                    setRightAnsBg(rightAns)
                    setWrongAnsBg(selectedOption)
                }
                btnClickDone = true
                btnSubmit.text = "Click To Get Next Question !!"
                if (currentPosition-1 == questionList.size) {
                    btnSubmit.text = "Click To Get Result !!"
                }
            }
        }
    }

    fun setRightAnsBg(i: Int) {
        when (i) {
            1 -> tvOptionA.background = ContextCompat.getDrawable(this, R.drawable.right_ans)
            2 -> tvOptionB.background = ContextCompat.getDrawable(this, R.drawable.right_ans)
            3 -> tvOptionC.background = ContextCompat.getDrawable(this, R.drawable.right_ans)
            4 -> tvOptionD.background = ContextCompat.getDrawable(this, R.drawable.right_ans)
        }
    }

    fun setWrongAnsBg(i: Int) {
        when (i) {
            1 -> tvOptionA.background = ContextCompat.getDrawable(this, R.drawable.wrong_ans)
            2 -> tvOptionB.background = ContextCompat.getDrawable(this, R.drawable.wrong_ans)
            3 -> tvOptionC.background = ContextCompat.getDrawable(this, R.drawable.wrong_ans)
            4 -> tvOptionD.background = ContextCompat.getDrawable(this, R.drawable.wrong_ans)
        }
    }

    private fun defaultColorSet(textView: TextView) {
        textView.setTextColor(Color.parseColor("#A8A8A8"))
        textView.setTypeface(Typeface.DEFAULT)
        textView.background = ContextCompat.getDrawable(this, R.drawable.optionorder)
    }

    private fun selectedColorSet(textView: TextView) {
        textView.setTextColor(Color.parseColor("#A934FD"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }

    private fun setQuestion(): Int {

        val question = questionList[currentPosition - 1]
        tvProgressText.text = "${currentPosition} /10"
        progressBar.progress = currentPosition
        tvQuestion.text = question.question
        tvOptionA.text = question.option1
        tvOptionB.text = question.option2
        tvOptionC.text = question.option3
        tvOptionD.text = question.option4
        rightAns = question.ans
        imgQuestion.setImageResource(question.image)

        if (questionList.size == currentPosition) {
            btnSubmit.text = "FINISH"
        } else {
            btnSubmit.text = "SUBMIT"
        }
        return question.ans
    }
}