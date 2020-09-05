package cl.talentodigital.aves.sessionlista.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.databinding.AvesItemBinding
import cl.talentodigital.aves.sessionlista.domain.model.Ave

 class AvesViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
                tvUid.text.toString()



        }
    }
}