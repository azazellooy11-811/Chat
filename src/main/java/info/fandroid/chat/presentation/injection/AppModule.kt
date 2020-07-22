package info.fandroid.chat.presentation.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import info.fandroid.chat.data.account.AccountCache
import info.fandroid.chat.data.account.AccountRemote
import info.fandroid.chat.data.account.AccountRepositoryImpl
import info.fandroid.chat.data.friends.FriendsCache
import info.fandroid.chat.data.friends.FriendsRemote
import info.fandroid.chat.data.friends.FriendsRepositoryImpl
import info.fandroid.chat.data.media.MediaRepositoryImpl
import info.fandroid.chat.data.messages.MessagesCache
import info.fandroid.chat.data.messages.MessagesRemote
import info.fandroid.chat.data.messages.MessagesRepositoryImpl
import info.fandroid.chat.domain.account.AccountRepository
import info.fandroid.chat.domain.friends.FriendsRepository
import info.fandroid.chat.domain.media.MediaRepository
import info.fandroid.chat.domain.messages.MessagesRepository
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context

    @Provides
    @Singleton
    fun provideAccountRepository(remote: AccountRemote, cache: AccountCache): AccountRepository {
        return AccountRepositoryImpl(remote, cache)
    }

    @Provides
    @Singleton
    fun provideFriendsRepository(remote: FriendsRemote, accountCache: AccountCache, friendsCache: FriendsCache): FriendsRepository {
        return FriendsRepositoryImpl(accountCache, remote, friendsCache)
    }

    @Provides
    @Singleton
    fun provideMediaRepository(context: Context): MediaRepository {
        return MediaRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideMessagesRepository(remote: MessagesRemote, cache: MessagesCache, accountCache: AccountCache): MessagesRepository {
        return MessagesRepositoryImpl(remote, cache, accountCache)
    }
}