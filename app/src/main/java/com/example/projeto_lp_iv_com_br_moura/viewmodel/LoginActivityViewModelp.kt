package com.example.projeto_lp_iv_com_br_moura.viewmodel

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto_lp_iv_com_br_moura.BR
import com.example.projeto_lp_iv_com_br_moura.model.Usuario
import com.example.projeto_lp_iv_com_br_moura.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.projeto_lp_iv_com_br_moura.model.Result

class LoginActivityViewModelp(val loginRepository: LoginRepository): ViewModel(), Observable{

    @Bindable
    var email: String = ""

    @Bindable
    var password: String = ""

    @Bindable
    var loadingVisibility:  Int = View.GONE
    set(value){
        field = value
        notifyPropertyChange((BR.loadingVisibility))
    }

    @Bindable
    var erroMessage: String = ""
     set(value) {
         field = value
         notifyPropertyChange(BR.erroMessage)

     }

    val redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry()}

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    private fun notifyPropertyChange(fieldId: Int){
        callbacks.notifyCallbacks(this, fieldId, null)
    }

    fun formIsValid(): Boolean =
        this.email.isNotBlank() &&
            this.password.isNotBlank() &&
            Patterns.EMAIL_ADDRESS.matcher(this.email).matches()

    fun doLogin(){
        this.loadingVisibility = View.VISIBLE

        // CHECAGEM
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginRepository.login(email, password)

            when(result) {
                is Result.Success<Usuario> -> redirect.postValue(true)
                is Result.Error -> showError(result.exception.message)
            }

            loadingVisibility = View.GONE
        }
    }

    private fun showError(message: String?){
        this.erroMessage = message ?: "Erro Desconhecido"
    }




}