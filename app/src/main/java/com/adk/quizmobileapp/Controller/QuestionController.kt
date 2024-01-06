package com.adk.quizmobileapp.Controller

import com.adk.quizmobileapp.Question
import com.adk.quizmobileapp.R

object QuestionController {
    fun getQuestion() : ArrayList<Question>
    {
        val questionList : ArrayList<Question> = ArrayList<Question>();
        questionList.add(Question(1,"What country does this flag belong to?", R.drawable.ic_flag_of_argentina,"Argentina","Australia","Armenia","Austria",1))
        questionList.add(Question(2,"What country does this flag belong to?", R.drawable.ic_flag_of_fiji,"Fiji","Belgium","New zealand","Germany",1))
        questionList.add(Question(3,"What country does this flag belong to?", R.drawable.ic_flag_of_india,"Denmark","India","Fiji","Kuwait",2))
        questionList.add(Question(4,"What country does this flag belong to?", R.drawable.ic_flag_of_brazil,"Shri lanka","USA","Belgium","Brazil",4))
        questionList.add(Question(5,"What country does this flag belong to?", R.drawable.ic_flag_of_kuwait,"China","UK","UAE","Kuwait",4))
        questionList.add(Question(6,"What country does this flag belong to?", R.drawable.ic_flag_of_belgium,"Korea","Belgium","Russia","Austria",2))
        questionList.add(Question(7,"What country does this flag belong to?", R.drawable.ic_flag_of_denmark,"Argentina","Myanmar","Denmark","Austria",3))
        questionList.add(Question(8,"What country does this flag belong to?", R.drawable.ic_flag_of_germany,"Pakistan","Germany","Armenia","Belgium",2))
        questionList.add(Question(9,"What country does this flag belong to?", R.drawable.ic_flag_of_australia,"Argentina","Australia","Armenia","Austria",2))
        questionList.add(Question(10,"What country does this flag belong to?", R.drawable.ic_flag_of_new_zealand,"Argentina","Australia","Armenia","New zealand",4))
        return questionList;
    }
}