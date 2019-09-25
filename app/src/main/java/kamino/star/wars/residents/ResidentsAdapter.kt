package kamino.star.wars.residents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kamino.star.wars.R

class ResidentsAdapter : RecyclerView.Adapter<ResidentsAdapter.ResidentViewHolder>() {

    private var residents = emptyList<Resident>()

    fun updateItems(newItems: List<Resident>) {
        residents = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return residents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResidentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.resident_view_holder, parent, false)
        return ResidentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResidentViewHolder, position: Int) {
        holder.bind(residents[position])
    }

    class ResidentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val residentNameTextView: TextView =
            itemView.findViewById(R.id.residentNameTextView)

        fun bind(data: Resident) {
            residentNameTextView.text = data.name
        }
    }
}
