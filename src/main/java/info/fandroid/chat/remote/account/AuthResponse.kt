package info.fandroid.chat.remote.account

import info.fandroid.chat.domain.account.AccountEntity
import info.fandroid.chat.remote.core.BaseResponse

class AuthResponse(
    success: Int,
    message: String,
    val user: AccountEntity
) : BaseResponse(success, message)