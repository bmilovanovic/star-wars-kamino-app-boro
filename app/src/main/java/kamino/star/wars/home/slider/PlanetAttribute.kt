package kamino.star.wars.home.slider

import android.graphics.Color
import androidx.annotation.StringRes

data class PlanetAttribute(@StringRes val textRes: Int, val text: String) {

    val color: Int = niceColors.shuffled().take(1)[0]

    companion object {
        val niceColors = listOf(
            Color.parseColor("#280f34"),
            Color.parseColor("#7bcace"),
            Color.parseColor("#678eb4"),
            Color.parseColor("#4f4e79"),
            Color.parseColor("#4e709d")
        )
    }
}
