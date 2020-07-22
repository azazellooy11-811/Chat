package info.fandroid.chat.ui.user

import android.os.Bundle
import info.fandroid.chat.ui.App
import info.fandroid.chat.ui.core.BaseActivity
import info.fandroid.chat.ui.core.BaseFragment

class UserActivity : BaseActivity() {
    override var fragment: BaseFragment = UserFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
