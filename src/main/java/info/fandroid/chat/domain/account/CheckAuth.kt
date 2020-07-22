package info.fandroid.chat.domain.account

import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.Either
import info.fandroid.chat.domain.type.Failure
import info.fandroid.chat.domain.type.None
import javax.inject.Inject

class CheckAuth @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<Boolean, None>() {

    override suspend fun run(params: None): Either<Failure, Boolean> = accountRepository.checkAuth()
}