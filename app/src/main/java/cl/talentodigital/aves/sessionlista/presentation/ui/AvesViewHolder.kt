package cl.talentodigital.aves.sessionlista.presentation.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.databinding.AvesItemBinding
import cl.talentodigital.aves.sessionlista.domain.model.Ave
import com.squareup.picasso.Picasso

class AvesViewHolder (itemView : View, private val avesItemClickListener: AvesItemClickListener?) : RecyclerView.ViewHolder(itemView) {

    private val binding = AvesItemBinding.bind(itemView)

    fun bind(ave: Ave) {
        binding.apply {
            Picasso.get().load(ave.images.toString()).into(binding.ivImageView)
            tvUid.text.toString()
            tvSort.text.toString()
            cvItemAves.setOnClickListener { avesItemClickListener?. onAvesItemClickListener(ave) }
        }


    }
}