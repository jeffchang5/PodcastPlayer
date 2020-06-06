package io.jeffchang.nasademo.ui.photo.repository

import com.nhaarman.mockitokotlin2.*
import io.jeffchang.core.Failure
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import io.jeffchang.nasademo.ui.photo.data.Photo
import io.jeffchang.nasademo.ui.photo.data.Response
import io.jeffchang.nasademo.ui.photo.data.service.PhotoService
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.HttpException
import kotlin.test.assertTrue

class PhotoRepositoryTest {

    private val photoService: PhotoService = mock()

    private val photoRepository = PhotoRepository(
        TestContextProvider(),
        photoService
    )

    @Test
    fun `get photos return list of photos upon success`() {
        runBlocking {
            // Given

            // When
            whenever(photoService.getPhotos()).doReturn(Response(listOf(Photo())))
            val result = photoRepository.getPhotos()

            // Then
            assertTrue { result is Success }
            verify(photoService, times(1)).getPhotos()
        }
    }

    @Test
    fun `get photos on http exception returns failure`() {
        runBlocking {
            // Given

            // When
            whenever(photoService.getPhotos()).thenThrow(
                HttpException(
                    retrofit2.Response.error<Response>(
                        404, ResponseBody.create(null, "")
                    )
                )
            )
            val result = photoRepository.getPhotos()

            // Then
            assertTrue { result is Failure }
            verify(photoService, times(1)).getPhotos()
        }
    }

}