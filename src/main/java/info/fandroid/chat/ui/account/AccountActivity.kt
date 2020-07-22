package info.fandroid.chat.ui.account

import android.os.Bundle
import info.fandroid.chat.ui.App
import info.fandroid.chat.ui.core.BaseActivity
import info.fandroid.chat.ui.core.BaseFragment

class AccountActivity : BaseActivity() {
    override var fragment: BaseFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
