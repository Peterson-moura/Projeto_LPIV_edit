package com.example.projeto_lp_iv_com_br_moura.repository

import com.example.projeto_lp_iv_com_br_moura.model.Usuario
import kotlinx.coroutines.delay
import com.example.projeto_lp_iv_com_br_moura.model.Result
import java.lang.Exception

class LoginRepository {

    suspend fun login(email: String, password: String): Result<Usuario> {
        return this.simulacaoDeChamadaParaService(email, password)
    }

    private suspend fun simulacaoDeChamadaParaService(email: String, password: String): Result<Usuario> {
        delay(2000)

        return when(verifyPassword(email, password)) {
            true -> Result.Success(Usuario(email, password))
            false -> Result.Error(Exception("Email ou senha Invalidos"))
        }

    }

    private fun verifyPassword(email: String, password: String): Boolean {
        val fakeUser = Usuario("admin@admin.com", "admin")

        return email == fakeUser.email && password == fakeUser.password
    }

}