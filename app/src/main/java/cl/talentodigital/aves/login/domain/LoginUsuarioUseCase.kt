package cl.talentodigital.aves.login.domain

import android.provider.ContactsContract

class LoginUsuarioUseCase(
    private val repository: LoginUsuarioRepository
) {

suspend fun excecute (email:String, clave :String) = repository.doLogin(email,clave)
}