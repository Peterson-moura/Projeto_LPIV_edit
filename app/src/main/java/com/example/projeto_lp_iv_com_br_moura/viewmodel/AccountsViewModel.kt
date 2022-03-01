package com.example.projeto_lp_iv_com_br_moura.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class AccountsViewModel : ViewModel() {

    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Seção $it onde ficarão a lista de contas"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }

}