package cl.talentodigital.aves.sessionlista.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentAvesBinding
import cl.talentodigital.aves.sessionlista.data.remote.AveMapper
import cl.talentodigital.aves.sessionlista.data.remote.RemoteAvesRepository
import cl.talentodigital.aves.sessionlista.domain.ObtenerAveUseCase
import cl.talentodigital.aves.sessionlista.domain.model.Ave
import cl.talentodigital.aves.sessionlista.domain.model.Aves
import cl.talentodigital.aves.sessionlista.presentation.AvesUiState
import cl.talentodigital.aves.sessionlista.presentation.AvesViewModel
import cl.talentodigital.aves.sessionlista.presentation.AvesViewModelFactory
import cl.talentodigital.network.RetrofitHandler

class AvesFragment : Fragment(R.layout.fragment_aves),AvesItemClickListener {


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
        viewModelFactory =
            AvesViewModelFactory(
                ObtenerAveUseCase(
                    RemoteAvesRepository(
                        RetrofitHandler.getAveApi(),
                        AveMapper()
                    )
                )
            )

        viewModel = ViewModelProvider(this, viewModelFactory).get(AvesViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLivaData().observe(
            viewLifecycleOwner,
            Observer { state -> state?.let { handleState(it) } }
        )
        viewModel.obtenerAves()
    }

    private fun handleState(state: AvesUiState) {
        when (state) {
            is AvesUiState.LoadingAvesState -> showLoading()
            is AvesUiState.SuccessAvesState -> showLoad(state.result)
            is AvesUiState.EmptyListAvesState -> showEmpty()
            is AvesUiState.ErrorServerAvesState -> showError()
            is AvesUiState.NotInternetAvesState -> showNotInternet()
        }

    }

    private fun showLoading() {

    }

    private fun showLoad(aves: Aves) {
        Toast.makeText(context, "total de aves ${aves.result.size}", Toast.LENGTH_SHORT).show()
        avesAdapter =
            AvesAdapter(aves.result,this)
        binding.rvAves.adapter = avesAdapter
    }

    private fun showEmpty() {
    }

    private fun showError() {
        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
    }

    private fun showNotInternet() {
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvAves.setHasFixedSize(true)
            rvAves.layoutManager = LinearLayoutManager(
                requireContext())
           rvAves.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL))

        }
    }

    override fun onAvesItemClickListener(view: View, ave: Ave) {
        val name = "aveEjemplo"
        val habitad = "sur de chile"
        val bundle = Bundle().apply {
            putString("aveEjemplo", name)
            putString("sur de chile", habitad)
        }
        Navigation.findNavController(view).navigate(R.id.action_avesFragment_to_detalleAvesFragment,bundle)
        }


    }


