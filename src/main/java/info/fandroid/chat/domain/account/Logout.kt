package info.fandroid.chat.domain.account

import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.Either
import info.fandroid.chat.domain.type.Failure
import info.fandroid.chat.domain.type.None
import javax.inject.Inject

class Logout @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, None>() {

    override suspend fun run(params: None): Either<Failure, None> = accountRepository.logout()
}