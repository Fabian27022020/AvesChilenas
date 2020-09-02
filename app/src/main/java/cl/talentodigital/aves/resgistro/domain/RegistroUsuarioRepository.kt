package cl.talentodigital.aves.resgistro.domain

interface RegistroUsuarioRepository {

  suspend fun registro (registroUsuario : RegistroUsuario) : Boolean
}