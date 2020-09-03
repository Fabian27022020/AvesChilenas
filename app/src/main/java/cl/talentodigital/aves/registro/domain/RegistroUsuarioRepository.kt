package cl.talentodigital.aves.registro.domain

interface RegistroUsuarioRepository {

  suspend fun registro (registroUsuario : RegistroUsuario) : Boolean
}