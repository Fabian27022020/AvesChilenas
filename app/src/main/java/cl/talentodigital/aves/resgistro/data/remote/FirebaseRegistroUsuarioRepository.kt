package cl.talentodigital.aves.resgistro.data.remote

import cl.talentodigital.aves.resgistro.domain.RegistroUsuario
import cl.talentodigital.aves.resgistro.domain.RegistroUsuarioRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await

class FirebaseRegistroUsuarioRepository (
    private val firebaseAuth: FirebaseAuth
): RegistroUsuarioRepository {


    override suspend fun registro(registroUsuario: RegistroUsuario): Boolean {
        val result = firebaseAuth
            .createUserWithEmailAndPassword(registroUsuario.email, registroUsuario.password)
            .await()
        val user = firebaseAuth.currentUser
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(registroUsuario.nombre)
            .build()
        user?.updateProfile(profileUpdates)?.await()
        return result.user?.email?.isNotEmpty() ?: false
    }
}