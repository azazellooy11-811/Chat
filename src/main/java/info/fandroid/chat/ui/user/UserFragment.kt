package info.fandroid.chat.ui.user

import android.os.Bundle
import android.view.View
import info.fandroid.chat.R
import info.fandroid.chat.remote.service.ApiService
import info.fandroid.chat.ui.core.BaseFragment
import info.fandroid.chat.ui.core.GlideHelper
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_user

    override val titleToolbar = R.string.screen_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        base {
            val args = intent.getBundleExtra("args")
            if (args != null) {
                val image = args.getString(ApiService.PARAM_IMAGE)
                val name = args.getString(ApiService.PARAM_NAME)
                val email = args.getString(ApiService.PARAM_EMAIL)
                val status = args.getString(ApiService.PARAM_STATUS)

                val id = args.getLong(ApiService.PARAM_CONTACT_ID)

                GlideHelper.loadImage(requireContext(), image, imgPhoto, R.drawable.ic_account_circle)

                tvName.text = name
                tvEmail.text = email
                tvStatus.text = status

                if (tvStatus.text.isEmpty()) {
                    tvStatus.visibility = View.GONE
                    tvHintStatus.visibility = View.GONE
                }

                imgPhoto.setOnClickListener {
                    navigator.showImageDialog(requireContext(), imgPhoto.drawable)
                }

                btnSendMessage.setOnClickListener {
                    navigator.showChatWithContact(id, name, requireContext())
                }
            }
        }
    }
}