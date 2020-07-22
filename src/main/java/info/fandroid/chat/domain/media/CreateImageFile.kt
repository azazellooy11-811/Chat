package info.fandroid.chat.domain.media

import android.net.Uri
import info.fandroid.chat.domain.interactor.UseCase
import info.fandroid.chat.domain.type.None
import javax.inject.Inject

class CreateImageFile @Inject constructor(
    private val mediaRepository: MediaRepository
) : UseCase<Uri, None>() {

    override suspend fun run(params: None) = mediaRepository.createImageFile()
}