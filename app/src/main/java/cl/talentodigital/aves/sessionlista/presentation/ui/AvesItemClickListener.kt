package cl.talentodigital.aves.sessionlista.presentation.ui

import android.view.View
import cl.talentodigital.aves.sessionlista.domain.model.Ave

interface AvesItemClickListener {

    fun onAvesItemClickListener(view :View , ave: Ave)
}