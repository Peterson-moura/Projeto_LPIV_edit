package com.example.projeto_lp_iv_com_br_moura.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projeto_lp_iv_com_br_moura.repository.LoginRepository
import com.example.projeto_lp_iv_com_br_moura.view.LoginActivity

object LoginActivityViewModelFactoryp: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginActivityViewModelp::class.java)) {
            val repository = LoginRepository()
            return LoginActivityViewModelp(repository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }


}