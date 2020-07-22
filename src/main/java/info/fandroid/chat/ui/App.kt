package info.fandroid.chat.ui

import android.app.Application
import dagger.Component
import info.fandroid.chat.presentation.injection.AppModule
import info.fandroid.chat.presentation.injection.CacheModule
import info.fandroid.chat.presentation.injection.RemoteModule
import info.fandroid.chat.presentation.injection.ViewModelModule
import info.fandroid.chat.ui.account.AccountActivity
import info.fandroid.chat.ui.account.AccountFragment
import info.fandroid.chat.ui.core.navigation.RouteActivity
import info.fandroid.chat.ui.firebase.FirebaseService
import info.fandroid.chat.ui.friends.FriendRequestsFragment
import info.fandroid.chat.ui.friends.FriendsFragment
import info.fandroid.chat.ui.home.HomeActivity
import info.fandroid.chat.ui.home.ChatsFragment
import info.fandroid.chat.ui.home.MessagesActivity
import info.fandroid.chat.ui.home.MessagesFragment
import info.fandroid.chat.ui.login.ForgetPasswordFragment
import info.fandroid.chat.ui.login.LoginFragment
import info.fandroid.chat.ui.register.RegisterActivity
import info.fandroid.chat.ui.register.RegisterFragment
import info.fandroid.chat.ui.user.UserActivity
import info.fandroid.chat.ui.user.UserFragment
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)
    fun inject(activity: RouteActivity)
    fun inject(activity: HomeActivity)
    fun inject(activity: AccountActivity)
    fun inject(activity: MessagesActivity)
    fun inject(activity: UserActivity)

    //fragments
    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: ChatsFragment)
    fun inject(fragment: FriendsFragment)
    fun inject(fragment: FriendRequestsFragment)
    fun inject(fragment: AccountFragment)
    fun inject(fragment: MessagesFragment)
    fun inject(fragment: UserFragment)
    fun inject(fragment: ForgetPasswordFragment)

    //services
    fun inject(service: FirebaseService)
}