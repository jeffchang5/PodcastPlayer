package io.jeffchang.nasademo.ui.photo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.jeffchang.core.*
import io.jeffchang.core.data.ViewState
import io.jeffchang.nasademo.ui.photo.data.model.Photo
import io.jeffchang.nasademo.ui.photo.repository.PhotoRepository
import io.jeffchang.nasademo.ui.photo.usecase.GetMalformedPhotosUseCase
import io.jeffchang.nasademo.ui.photo.usecase.GetNASAPhotosUseCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class PhotoViewModelTest {

    private val coroutineContext = TestContextProvider()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun `non-empty employee list is success viewstate`() {
        runBlocking {
            val photoRepository: PhotoRepository = mock()
            whenever(photoRepository.getPhotos()).doReturn(Success(listOf(Photo())))

            val useCase = GetNASAPhotosUseCase(photoRepository)
            val malformedUseCase = GetMalformedPhotosUseCase(photoRepository)

            val photoViewModel = PhotoViewModel(
                this@PhotoViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            photoViewModel.viewState().value shouldBeInstanceOf ViewState.Success::class
        }
    }

    @Test
    fun `empty employee list is empty viewstate`() {
        runBlocking {
            val photoRepository: PhotoRepository = mock()
            whenever(photoRepository.getPhotos()).doReturn(Success(listOf()))

            val useCase = GetNASAPhotosUseCase(photoRepository)
            val malformedUseCase = GetMalformedPhotosUseCase(photoRepository)

            val photoViewModel = PhotoViewModel(
                this@PhotoViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            photoViewModel.viewState().value shouldBeInstanceOf ViewState.Empty::class
        }
    }

    @Test
    fun `network error throws is error viewstate`() {
        runBlocking {
            val photoRepository: PhotoRepository = mock()
            whenever(photoRepository.getPhotos()).doReturn(
                Failure(UnknownNetworkException)
            )

            val useCase = GetNASAPhotosUseCase(photoRepository)
            val malformedUseCase = GetMalformedPhotosUseCase(photoRepository)

            val photoViewModel = PhotoViewModel(
                this@PhotoViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            photoViewModel.viewState().value shouldBeInstanceOf ViewState.Error::class
        }
    }
}