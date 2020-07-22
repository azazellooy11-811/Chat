package info.fandroid.chat.domain.friends

import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.None
import javax.inject.Inject

class ApproveFriendRequest @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<None, FriendEntity>() {

    override suspend fun run(params: FriendEntity) = friendsRepository.approveFriendRequest(params)
}