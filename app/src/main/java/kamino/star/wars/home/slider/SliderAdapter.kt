package kamino.star.wars.home.slider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.smarteist.autoimageslider.SliderViewAdapter
import kamino.star.wars.R


class SliderAdapter : SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {

    private var items = emptyList<PlanetAttribute>()

    fun updateItems(newItems: List<PlanetAttribute>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_slider_layout_item, parent, false)
        return SliderAdapterVH(view)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.bind(items[position])
    }

    class SliderAdapterVH(view: View) : SliderViewAdapter.ViewHolder(view) {

        private var slideLayout: LinearLayout = view.findViewById(R.id.slideLayout)
        private var slideDescriptionTextView: TextView =
            view.findViewById(R.id.slideDescriptionTextView)
        private var slideTitleTextView: TextView = view.findViewById(R.id.slideTitleTextView)

        fun bind(data: PlanetAttribute) {
            slideLayout.setBackgroundColor(data.color)
            slideDescriptionTextView.setText(data.textRes)
            slideTitleTextView.text = data.text
        }
    }
}
