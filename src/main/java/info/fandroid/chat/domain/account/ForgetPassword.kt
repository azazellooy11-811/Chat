package info.fandroid.chat.domain.account

import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.None
import javax.inject.Inject

class ForgetPassword @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, ForgetPassword.Params>() {

    override suspend fun run(params: Params) = accountRepository.forgetPassword(params.email)

    data class Params(val email: String)
}