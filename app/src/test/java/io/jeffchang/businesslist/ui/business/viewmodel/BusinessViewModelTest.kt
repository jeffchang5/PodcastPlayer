package io.jeffchang.businesslist.ui.business.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.jeffchang.core.*
import io.jeffchang.core.data.ViewState
import io.jeffchang.businesslist.ui.business.repository.BusinessRepository
import io.jeffchang.businesslist.ui.business.usecase.GetMalformedBusinesssUseCase
import io.jeffchang.businesslist.ui.business.usecase.DefaultGetBusinessUseCase
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class BusinessViewModelTest {

    private val coroutineContext = TestContextProvider()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun `non-empty employee list is success viewstate`() {
        runBlocking {
            val BusinessRepository: BusinessRepository = mock()
            whenever(BusinessRepository.getBusinesses()).doReturn(Success(listOf(Business())))

            val useCase = DefaultGetBusinessUseCase(BusinessRepository)
            val malformedUseCase = GetMalformedBusinesssUseCase(BusinessRepository)

            val BusinessViewModel = BusinessViewModel(
                this@BusinessViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            BusinessViewModel.viewState().value shouldBeInstanceOf ViewState.Success::class
        }
    }

    @Test
    fun `empty employee list is empty viewstate`() {
        runBlocking {
            val BusinessRepository: BusinessRepository = mock()
            whenever(BusinessRepository.getBusinesses()).doReturn(Success(listOf()))

            val useCase = DefaultGetBusinessUseCase(BusinessRepository)
            val malformedUseCase = GetMalformedBusinesssUseCase(BusinessRepository)

            val BusinessViewModel = BusinessViewModel(
                this@BusinessViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            BusinessViewModel.viewState().value shouldBeInstanceOf ViewState.Empty::class
        }
    }

    @Test
    fun `network error throws is error viewstate`() {
        runBlocking {
            val BusinessRepository: BusinessRepository = mock()
            whenever(BusinessRepository.getBusinesses()).doReturn(
                Failure(UnknownNetworkException)
            )

            val useCase = DefaultGetBusinessUseCase(BusinessRepository)
            val malformedUseCase = GetMalformedBusinesssUseCase(BusinessRepository)

            val BusinessViewModel = BusinessViewModel(
                this@BusinessViewModelTest.coroutineContext, useCase, malformedUseCase
            )

            BusinessViewModel.viewState().value shouldBeInstanceOf ViewState.Error::class
        }
    }
}