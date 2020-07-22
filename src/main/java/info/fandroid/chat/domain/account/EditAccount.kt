package info.fandroid.chat.domain.account

import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.Either
import info.fandroid.chat.domain.type.Failure
import javax.inject.Inject

class EditAccount @Inject constructor(
    private val repository: AccountRepository
) : UseCase<AccountEntity, AccountEntity>() {

    override suspend fun run(params: AccountEntity): Either<Failure, AccountEntity> {
        return repository.editAccount(params)
    }
}