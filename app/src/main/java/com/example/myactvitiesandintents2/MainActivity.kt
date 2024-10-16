package com.example.myactvitiesandintents2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.editTextMain)
        val sendButton: Button = findViewById(R.id.main_send_button)
        sendButton.setOnClickListener {
            val message = editText.text.toString()
            // Create an intent with URI
            val messageUri = Uri.parse("message:$message")
            val intent = Intent(this, SecondActivity::class.java).apply {
                data = messageUri // Pass URI as intent data
            }
            startActivity(intent)
        }

    }

    // Receiving reply from SecondActivity using intent extras
    override fun onResume() {
        super.onResume()
        intent?.let {
            if (it.hasExtra("reply")) {
                val reply = it.getStringExtra( "reply")
                // editText.setText("Reply: $reply") // Display reply
                val repliedMessageView : TextView = findViewById( R.id.repliedMessage)
                repliedMessageView .setText("Reply: $reply") // Display reply
            }
        }
    }


}