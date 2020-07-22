package info.fandroid.chat.ui.home

import android.os.Bundle
import info.fandroid.chat.ui.App
import info.fandroid.chat.ui.core.BaseActivity
import info.fandroid.chat.ui.core.BaseFragment

class MessagesActivity : BaseActivity() {
    override var fragment: BaseFragment = MessagesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }
}
