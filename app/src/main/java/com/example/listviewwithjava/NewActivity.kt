package com.example.listviewwithjava

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val actionBar = supportActionBar
        val mDetailTv = findViewById<TextView>(R.id.textview)
        val intent = intent
        val actionbartitle = intent.getStringExtra("ActionBarTitle")
        val mcontent = intent.getStringExtra("ContentTv")
        //set action bar title
        actionBar!!.title = actionbartitle
        //set action content(set text in textview)
        mDetailTv.text = mcontent
    }
}