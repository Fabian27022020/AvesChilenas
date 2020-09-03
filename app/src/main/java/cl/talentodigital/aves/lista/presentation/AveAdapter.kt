package cl.talentodigital.aves.lista.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.R
import cl.talentodigital.aves.lista.domain.model.Ave


class AveAdapter (
    private val list: List<Ave>
) : RecyclerView.Adapter<AveViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.aves_item, parent, false)
        return AveViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AveViewHolder, position: Int) {
        holder.bind(list[position])
    }

}