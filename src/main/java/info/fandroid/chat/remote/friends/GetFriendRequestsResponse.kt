package info.fandroid.chat.remote.friends

import com.google.gson.annotations.SerializedName
import info.fandroid.chat.domain.friends.FriendEntity
import info.fandroid.chat.remote.core.BaseResponse

class GetFriendRequestsResponse (
    success: Int,
    message: String,
    @SerializedName("friend_requests")
    val friendsRequests: List<FriendEntity>
) : BaseResponse(success, message)