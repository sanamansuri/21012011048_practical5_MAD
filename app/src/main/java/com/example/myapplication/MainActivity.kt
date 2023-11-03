package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implicitIntent()
    }
    private fun implicitIntent()
    {
        findViewById<Button>(R.id.btnbrowse).setOnClickListener {
            Log.i("click","MainActivity")
            Intent(Intent.ACTION_VIEW, Uri.parse(findViewById<EditText>(R.id.editTextText).text.toString())).also { startActivity(it) }
        }
        findViewById<Button>(R.id.button2).setOnClickListener {

            val number=findViewById<EditText>(R.id.editTextText2).text.toString().trim()
            Intent(Intent.ACTION_DIAL).setData((Uri.parse("Tel:$number"))).apply {
                startActivity(this)
            }
            findViewById<Button>(R.id.button3).setOnClickListener {

                Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
            }
            findViewById<Button>(R.id.button4).setOnClickListener {

                Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
            }
            findViewById<Button>(R.id.button5).setOnClickListener {

                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
            }
            findViewById<Button>(R.id.button6).setOnClickListener {

                Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
            }
        }

    }

}