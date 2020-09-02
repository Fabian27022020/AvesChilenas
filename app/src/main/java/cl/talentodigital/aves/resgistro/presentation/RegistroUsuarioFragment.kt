package cl.talentodigital.aves.resgistro.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentRegistroUsuarioBinding
import cl.talentodigital.aves.resgistro.data.remote.FirebaseRegistroUsuarioRepository
import cl.talentodigital.aves.resgistro.domain.RegistroUsuario
import cl.talentodigital.aves.resgistro.domain.RegistroUsuarioUseCase
import cl.talentodigital.aves.utils.extension.*
import com.google.firebase.auth.FirebaseAuth

class RegistroUsuarioFragment : Fragment(R.layout.fragment_registro_usuario) {

    lateinit var binding: FragmentRegistroUsuarioBinding
    lateinit var viewModel: RegistroUsuarioViewModel
    lateinit var viewModelFactory: RegistroUsuarioViewModelFactory


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependecies()
        binding = FragmentRegistroUsuarioBinding.bind(view)
        setupLiveData()
        setupListener()
    }

    private fun setupDependecies() {
        viewModelFactory = RegistroUsuarioViewModelFactory(
            RegistroUsuarioUseCase(
                FirebaseRegistroUsuarioRepository(FirebaseAuth.getInstance())
            )
        )
        viewModel = ViewModelProvider(
            this,viewModelFactory).get(RegistroUsuarioViewModel::class.java)

    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { state ->
                state?.let { handleState(it) }
            }
        )
    }

    private fun handleState(state: RegistroUsuarioUiState) {
        when(state){
            is RegistroUsuarioUiState.LoadingRegistroUsuarioUiState -> showLoading()
            is RegistroUsuarioUiState.SuccessRegistroUiState -> showSuccess()
            is RegistroUsuarioUiState.InvalidEmailRegistroUiState -> showInvalid()
            is RegistroUsuarioUiState.ErrorRegistroUiState -> showError()
        }
    }

    private fun showLoading() {
        alert("Cargando ......")
    }

    private fun showSuccess() {
        alert("Registro Exitoso")
    }

    private fun showInvalid() {
        alert("Email Invalido")
    }

    private fun showError() {
        alert("Lo sentimos ha ocurrido un Error")
    }

    private fun setupListener() {
        binding.apply {
             btnRegistrar.setOnClickListener {
                if (isAllValidinput()){
                    viewModel.registrarUsuario(obtenerValoresEditText())
                }
            }
            btnVolver.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun isAllValidinput(): Boolean {
        binding.apply {
            return etPass.isValidPassInput("ingrese contraseña con 6 caracteres")||
            return etEmail.isValidEmailInput("ingrese email valido")||
            return etRut.isValidRutInput("ingrese rut valido")||
            return etNombre.isValidNameInput("ingrese un nombre valido")
        }
    }

    private fun obtenerValoresEditText(): RegistroUsuario {
        binding.apply {
            return RegistroUsuario(
                etNombre.text.toString(),
                etRut.text.toString(),
                etEmail.text.toString(),
                etPass.text.toString()
            )
        }
    }


}