package com.example.expandedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ExpandableTextView>(R.id.customview).setSubText("asdhjsgdjkhgsjhdgjhsgdjasdhjsgdjkhgsjhdgjhsgdjasdhjsgdjkhgsjhdgjhsgdjasdhjsgdjkhgsjhdgjhsgdjasdhjsgdjkhgsjhdgjhsgdj")
    }
}