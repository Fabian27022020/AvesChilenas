package cl.talentodigital.aves.sessionlista.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentAvesBinding
import cl.talentodigital.aves.sessionlista.domain.AveRepository
import io.reactivex.disposables.CompositeDisposable

class AveFragment : Fragment(R.layout.fragment_aves) {

    private lateinit var binding: FragmentAvesBinding
    private lateinit var viewModel: AveViewModel
    private lateinit var viewModelFactory: AveViewModelFactory
    private lateinit var aveAdapter: AveAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        binding = FragmentAvesBinding()
        setupLiveData()
        setupRecyclerView()

    }

    private fun setupDependencies() {
        viewModelFactory = AveViewModelFactory()

    }
    private fun setupLiveData() {
        viewModel.getLivaData()
    }

    private fun setupRecyclerView() {
        TODO("Not yet implemented")
    }


}