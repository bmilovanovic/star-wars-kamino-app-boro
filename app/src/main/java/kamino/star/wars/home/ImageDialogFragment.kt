package kamino.star.wars.home

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import kamino.star.wars.R

class ImageDialogFragment : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_Dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString(imageUrlKey)?.let { imageUrl ->
            val imagePreview = view.findViewById(R.id.imagePreview) as ImageView
            Glide.with(imagePreview)
                .load(imageUrl)
                .into(imagePreview)
        }
    }

    @Suppress("UsePropertyAccessSyntax")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity!!, getTheme())
        dialog.setCanceledOnTouchOutside(true)
        setCancelable(true)
        return dialog
    }

    fun showAllowingStateLoss(fragmentManager: FragmentManager, tag: String) {
        fragmentManager.beginTransaction()
            .add(this, tag)
            .commitAllowingStateLoss()
    }

    companion object {
        const val tag = "ImageDialogFragment"
        private const val imageUrlKey = "image_url_key"

        fun newInstance(imageUrl: String): ImageDialogFragment {
            val bundle = Bundle()
            bundle.putString(imageUrlKey, imageUrl)

            val fragment = ImageDialogFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
