package com.example.projeto_lp_iv_com_br_moura.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.projeto_lp_iv_com_br_moura.R
import com.example.projeto_lp_iv_com_br_moura.databinding.ActivityLoginBinding
import com.example.projeto_lp_iv_com_br_moura.repository.LoginRepository
import com.example.projeto_lp_iv_com_br_moura.viewmodel.LoginActivityViewModelFactoryp
import com.example.projeto_lp_iv_com_br_moura.viewmodel.LoginActivityViewModelp
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginActivityViewModelp by lazy {
        ViewModelProvider(this, LoginActivityViewModelFactoryp)
            .get(LoginActivityViewModelp::class.java)


    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val loginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        loginBinding.viewmodel = loginViewModel

        loginViewModel.email = "admin@admin.com"
        loginViewModel.password = "admin"

        Picasso
            .get()
            .load("https://logodownload.org/wp-content/uploads/2014/09/watch-dogs-logo.jpg")
            .into(watchLogo)

        redirectToMainActivity()
    }


    fun login(view: View){
        if(loginViewModel.formIsValid()){
            loginViewModel.doLogin()

        }else{
            when {
                loginViewModel.password.isBlank() -> passwordET.error = getString(R.string.password_blank)
                loginViewModel.email.isBlank() -> emailET.error = getString(R.string.email_blank)
                else -> emailET.error = getString(R.string.email_invalid)
        }
    }
}
    fun redirectToMainActivity() {
        loginViewModel.redirect.observe(this) {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}