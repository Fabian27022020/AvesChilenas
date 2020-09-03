package cl.talentodigital.aves.lista.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import cl.talentodigital.aves.R
import cl.talentodigital.aves.databinding.FragmentAvesBinding
import cl.talentodigital.aves.lista.domain.AveRepository
import io.reactivex.disposables.CompositeDisposable

class AveFragment : Fragment(R.layout.fragment_aves) {

    private lateinit var binding: FragmentAvesBinding
    private lateinit var repository: AveRepository
    private lateinit var aveAdapter: AveAdapter
    private val compositeDisposable = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        callUseCaseObtener()
        bindView(view)
        setupRecyclerView()
        setupListener()

    }

    private fun setupDependencies() {



    }

    private fun callUseCaseObtener() {


    }

    private fun bindView(view: View) {
        TODO("Not yet implemented")
    }

    private fun setupRecyclerView() {
        TODO("Not yet implemented")
    }

    private fun setupListener() {
        TODO("Not yet implemented")
    }
}