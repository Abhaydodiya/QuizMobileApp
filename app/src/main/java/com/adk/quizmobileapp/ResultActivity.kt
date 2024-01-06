package com.adk.quizmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvScore : TextView
    lateinit var btnFinish : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        tvName = findViewById(R.id.tvName)
        tvScore = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)
        var getIntent : Intent = intent
        var intent : Intent = Intent(this,MainActivity::class.java)
        tvName.text = getIntent.getStringExtra("userName").toString()
        tvScore.text = getIntent.getStringExtra("result")

        btnFinish.setOnClickListener(){
            startActivity(intent)
        }

    }
}