package cl.talentodigital.aves.detalle.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.aves.R

import cl.talentodigital.aves.databinding.FragmentDetalleAveBinding
import cl.talentodigital.aves.detalle.data.remote.DetalleAveMapper
import cl.talentodigital.aves.detalle.data.remote.RemoteDetalleAveRepository
import cl.talentodigital.aves.detalle.domain.DetalleAveUseCase
import cl.talentodigital.aves.detalle.domain.model.DetalleAve
import cl.talentodigital.network.RetrofitHandler
import com.squareup.picasso.Picasso


class DetalleAvesFragment : Fragment(R.layout.fragment_detalle_ave) {

    private lateinit var binding: FragmentDetalleAveBinding
    private lateinit var viewModel: DetalleAveViewModel
    private lateinit var viewModelFactory: DetalleAveViewModelFactory


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       arguments?.let {
           safeArguments -> handleParams(safeArguments)
       }

        setupDependencies()
        binding = FragmentDetalleAveBinding.bind(view)
        setupLiveData()
    }

    private fun handleParams(safeBundle : Bundle) {
        safeBundle.apply {
            val name = getString("nombre")
            val habitat = getString("habitat")
        }

    }

    private fun setupDependencies() {
        viewModelFactory = 
            DetalleAveViewModelFactory(
                DetalleAveUseCase(
                    RemoteDetalleAveRepository(
                        RetrofitHandler.getDetalleApi(),
                        DetalleAveMapper()
                    )
                )
            )
        viewModel = ViewModelProvider(this,viewModelFactory).get(DetalleAveViewModel::class.java)
    }
    
    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { state -> state?.let { handkeState(it) } }
        )
        viewModel.obtenerDetalle()

    }

    private fun handkeState(state: DetalleAveState) {
        when (state){
            is DetalleAveState.LoadingDetalleState -> showLoading()
            is DetalleAveState.SuccessAvesState -> showLoad(state.result)
            is DetalleAveState.EmptyListAvesState -> showEmpty()
            is DetalleAveState.ErrorServerAvesState -> showError()
            is DetalleAveState.NotInternetAvesState -> showNotInternet()
        }
        
    }

    private fun showLoading() {
        
        
    }

    private fun showLoad(detalleAve : DetalleAve) {
        binding.apply {
            tvNombreEspanol.text = detalleAve.name?.spanish
            tvNombreEnIngles.text = detalleAve.name?.english
            tvNombreEnLatin.text = detalleAve.name?.latin
            tvHabitad.text = detalleAve.habitat
            tvDidyouknow.text = detalleAve.didyouknow
            tvSize.text = detalleAve.size
            tvDescripcion.text = detalleAve.iucn?.description
            tvSpecies.text = detalleAve.species
            tvTitle.text = detalleAve.map?.title
            Picasso.get().load(detalleAve.images?.main).into(binding.ivImagenAve)
            Picasso.get().load(detalleAve.map?.image).into(binding.ivImagenMapa)

        }
    }

    private fun showEmpty() {
        
        
    }

    private fun showError() {
        
        
    }

    private fun showNotInternet() {
        
        
    }


}