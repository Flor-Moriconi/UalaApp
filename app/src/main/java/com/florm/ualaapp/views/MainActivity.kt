package com.florm.ualaapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.florm.ualaapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToListActivity()
    }

    private fun goToListActivity() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}
