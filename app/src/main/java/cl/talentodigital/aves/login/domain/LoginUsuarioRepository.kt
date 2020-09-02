package cl.talentodigital.aves.login.domain

interface LoginUsuarioRepository {

    suspend fun doLogin(email : String, clave : String) : LoginUsuario
}