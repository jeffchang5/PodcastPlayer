package io.jeffchang.nasademo.ui.photo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import io.jeffchang.core.data.ViewState
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
    fun `non-empty employee list is successful`() {
        runBlocking {
            val photoRepository: PhotoRepository = mock()
            whenever(photoRepository.getPhotos()).doReturn(Success(listOf()))

            val useCase = GetNASAPhotosUseCase(photoRepository)
            val malformedUseCase = GetMalformedPhotosUseCase(photoRepository)

            val photoViewModel = PhotoViewModel(
                this@PhotoViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            photoViewModel.viewState().value shouldBeInstanceOf ViewState.Success::class
        }
    }
}