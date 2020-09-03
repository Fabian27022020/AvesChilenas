package cl.talentodigital.aves.lista.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.databinding.AvesItemBinding
import cl.talentodigital.aves.lista.domain.model.Ave

class AvesViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
                tvNombreAve.text = ave.name
                tvLink.text = ave.links
        }
    }
}