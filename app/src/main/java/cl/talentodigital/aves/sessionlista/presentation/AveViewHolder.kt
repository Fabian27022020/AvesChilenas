package cl.talentodigital.aves.sessionlista.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.databinding.AvesItemBinding
import cl.talentodigital.aves.sessionlista.domain.model.Ave

class AveViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
                tvNombreAve.text = ave.name.toString()
              //  tvLink.text = ave.links.
        }
    }
}