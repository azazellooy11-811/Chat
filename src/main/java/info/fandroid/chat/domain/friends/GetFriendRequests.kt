package info.fandroid.chat.domain.friends

import info.fandroid.chat.domain.interactor.UseCase
import javax.inject.Inject

class GetFriendRequests @Inject constructor(
    private val friendsRepository: FriendsRepository
) : UseCase<List<FriendEntity>, Boolean>() {

    override suspend fun run(needFetch: Boolean) = friendsRepository.getFriendRequests(needFetch)
}