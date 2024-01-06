package com.adk.quizmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    lateinit var btnStart : Button;
    lateinit var edtName: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btnStart);
        edtName = findViewById(R.id.edtName);
        val intent = Intent(this,QuizQuestionsActivity::class.java);
        btnStart.setOnClickListener(){
            val name : String = edtName.getText().trim().toString()
            if(name.isNotEmpty() && name != "")
            {
                intent.putExtra("userName",name)
                startActivity(intent)
            }
            else {
                edtName.error = "Please Enter Your Name !!"
                Toast.makeText(this, "Please Enter Your Name !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}