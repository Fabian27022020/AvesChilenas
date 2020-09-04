package cl.talentodigital.aves.sessionlista.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentAvesBinding
import cl.talentodigital.aves.sessionlista.data.remote.AveMapper
import cl.talentodigital.aves.sessionlista.data.remote.RemoteAvesRepository
import cl.talentodigital.aves.sessionlista.domain.ObtenerAveUseCase
import cl.talentodigital.aves.sessionlista.domain.model.Aves
import cl.talentodigital.network.RetrofitHandler

class AvesFragment : Fragment(R.layout.fragment_aves) {

    private lateinit var binding: FragmentAvesBinding
    private lateinit var viewModel: AvesViewModel
    private lateinit var viewModelFactory: AvesViewModelFactory
    private lateinit var avesAdapter: AvesAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentAvesBinding.bind(view)
        setupLiveData()
        setupRecyclerView()

    }

    private fun setupDependencies() {
        viewModelFactory = AvesViewModelFactory(
            ObtenerAveUseCase(
                RemoteAvesRepository(
                    RetrofitHandler.getAveApi(),
                    AveMapper()
                )
            )
        )

        ViewModel = ViewModelProvider(this, viewModelFactory).get(AvesViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLivaData().observe(
            viewLifecycleOwner,
            Observer { state -> state?.let { handleState(it) } }
        )
        viewModel.obtenerAves()
    }

    private fun handleState(state: AvesUiState) {
        when(state){
            is AvesUiState.LoadingAvesState -> showLoading()
            is AvesUiState.LoadAvesState -> showLoad()
            is AvesUiState.EmptyListAvesState -> showEmpty()
            is AvesUiState.ErrorServerAvesState -> showError()
            is AvesUiState.NotInternetAvesState -> showNotInternet()
        }


    }

    private fun showLoading() {

    }
    private fun showLoad() {
    }
    private fun showEmpty() {
    }
    private fun showError() {
    }
    private fun showNotInternet() {
    }

    private fun loadAaves(result: Aves){
        Toast.makeText(context, "result ${result.result.size}", Toast.LENGTH_SHORT).show()

    }

    private fun setupRecyclerView() {
        TODO("Not yet implemented")
    }


}