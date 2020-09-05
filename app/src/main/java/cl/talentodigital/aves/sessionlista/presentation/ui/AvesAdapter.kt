package cl.talentodigital.aves.sessionlista.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.aves.R
import cl.talentodigital.aves.sessionlista.domain.model.Ave


class AvesAdapter (
    private val list: List<Ave>
) : RecyclerView.Adapter<AvesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.aves_item, parent, false)
        return AvesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AvesViewHolder, position: Int) {
        holder.bind(list[position])
    }

}