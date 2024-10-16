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

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val receivedMessageView : TextView = findViewById( R.id.receivedMessage)
        val editText = findViewById<EditText>( R.id.editTextSecond)
        val sendButton: Button = findViewById( R.id.sendButtonSecond)
        // Get the URI from the intent
        intent?.data?.let { data: Uri ->
            val message = data.schemeSpecificPart // Extract the message
            receivedMessageView .text = "Received: $message"
        }
        sendButton.setOnClickListener {
            val replyMessage = editText.text.toString()
            // Sending the data back to MainActivity using intent extras
            val replyIntent = Intent(this, MainActivity::class.java).apply {
                // Using intent extras to send data
                putExtra("reply", replyMessage)
            }
            startActivity( replyIntent)
        }
    }
}