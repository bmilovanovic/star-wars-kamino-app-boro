package kamino.star.wars.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Returns custom factory for a delegated class.
 */
@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }
}
