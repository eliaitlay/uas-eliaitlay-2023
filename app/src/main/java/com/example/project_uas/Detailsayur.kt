package com.example.project_uas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.project_uas.databinding.ActivityDetailsayurBinding

class Detailsayur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailsayur)

        val sayur = intent.getParcelableExtra<Sayur>(MainActivity.INTENT_PARCELABLE)
        val imgSayur = findViewById<ImageView>(R.id.img_sayur)
        val namaSayur = findViewById<TextView>(R.id.tv_namasayur)
        val descSayur = findViewById<TextView>(R.id.tv_descsayur)

        imgSayur.setImageResource(sayur?.imgsayur!!)
        namaSayur.text=sayur.namasayur
        descSayur.text=sayur.dessayur

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

