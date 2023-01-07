package com.example.android_1stday

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.tvHello);
        val inputField = findViewById<EditText>(R.id.edtName);
        val submitBtn = this.findViewById<Button>(R.id.btnSubmit);
        val offerBtn = findViewById<Button>(R.id.btnOffers);
        var enteredName = "";


        submitBtn.setOnClickListener {
            enteredName = inputField.text.toString();
            if(enteredName == ""){
                greetingTextView.text = "";
                offerBtn.visibility = INVISIBLE;
                Toast.makeText(this@MainActivity, "Please, enter your name!", Toast.LENGTH_SHORT).show();
            }else{
                val message = "welcome $enteredName";
                greetingTextView.text = message;
                inputField.text.clear();
                offerBtn.visibility= VISIBLE;
            }
        }

        offerBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java);
            intent.putExtra("USER", enteredName);
            startActivity(intent);
        }
    }
}