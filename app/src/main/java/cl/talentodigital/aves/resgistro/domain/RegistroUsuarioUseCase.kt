package cl.talentodigital.aves.resgistro.domain

class RegistroUsuarioUseCase (private  val  registroUsuarioRepository: RegistroUsuarioRepository){

    suspend fun excecute (registroUsuario: RegistroUsuario) = registroUsuarioRepository.registro(registroUsuario)


}