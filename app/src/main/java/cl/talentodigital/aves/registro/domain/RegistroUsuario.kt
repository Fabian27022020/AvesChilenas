package cl.talentodigital.aves.registro.domain

data class RegistroUsuario (
    val nombre : String,
    val rut : String,
    val email : String,
    val  password : String
)