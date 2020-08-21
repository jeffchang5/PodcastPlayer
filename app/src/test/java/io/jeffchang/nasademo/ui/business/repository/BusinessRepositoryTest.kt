package io.jeffchang.nasademo.ui.business.repository

import com.nhaarman.mockitokotlin2.*
import io.jeffchang.core.Failure
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import io.jeffchang.nasademo.ui.business.data.model.Business
import io.jeffchang.nasademo.ui.business.data.model.Response
import io.jeffchang.nasademo.ui.business.data.service.BusinessService
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import retrofit2.HttpException

class BusinessRepositoryTest {

    private val BusinessService: BusinessService = mock()

    private val BusinessRepository = DefaultBusinessRepository(
        TestContextProvider(),
        BusinessService
    )

    @Test
    fun `get Businesss return list of Businesss upon success`() {
        runBlocking {
            // Given

            // When
            whenever(BusinessService.getBusinesss()).doReturn(
                Response(
                    listOf(Business())
                )
            )
            val result = BusinessRepository.getBusinesses()

            // Then
            result shouldBeInstanceOf Success::class
            verify(BusinessService, times(1)).getBusinesss()
        }
    }

    @Test
    fun `get Businesss on http exception returns failure`() {
        runBlocking {
            // Given

            // When
            whenever(BusinessService.getBusinesss()).thenThrow(
                HttpException(
                    retrofit2.Response.error<Response>(
                        404, ResponseBody.create(null, "")
                    )
                )
            )
            val result = BusinessRepository.getBusinesses()

            // Then
            result shouldBeInstanceOf Failure::class
            verify(BusinessService, times(1)).getBusinesss()
        }
    }

}