package kamino.star.wars.util

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper {

    companion object {
        private const val isLikedKey = "is_liked"

        fun isLiked(context: Context): Boolean {
            return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(isLikedKey, false)
        }

        fun setLiked(context: Context) {
            PreferenceManager.getDefaultSharedPreferences(context).edit()
                .putBoolean(isLikedKey, true)
                .apply()
        }
    }
}
