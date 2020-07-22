package info.fandroid.chat.remote.friends

import info.fandroid.chat.domain.friends.FriendEntity
import info.fandroid.chat.remote.core.BaseResponse

class GetFriendsResponse (
    success: Int,
    message: String,
    val friends: List<FriendEntity>
) : BaseResponse(success, message)