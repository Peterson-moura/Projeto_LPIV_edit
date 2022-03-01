package com.example.projeto_lp_iv_com_br_moura.view

import android.app.appsearch.GlobalSearchSession
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_lp_iv_com_br_moura.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Picasso
            .get()
            .load("https://i.pinimg.com/564x/c1/3d/46/c13d46a79c9b7bf1a0a104d39f98e54d.jpg")
            .into(DeadSecView)

        GlobalScope.launch {
            delay(5000)
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}