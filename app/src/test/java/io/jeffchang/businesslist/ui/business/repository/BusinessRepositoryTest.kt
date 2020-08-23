package io.jeffchang.businesslist.ui.business.repository

import com.nhaarman.mockitokotlin2.*
import io.jeffchang.businesslist.ui.business.data.model.business.Business
import io.jeffchang.businesslist.ui.business.data.model.business.Region
import io.jeffchang.businesslist.ui.business.data.model.business.Response
import io.jeffchang.businesslist.ui.business.data.service.BusinessService
import io.jeffchang.core.Failure
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import retrofit2.HttpException

class BusinessRepositoryTest {

    private val businessService: BusinessService = mock()

    private val businessRepository = DefaultBusinessRepository(
        TestContextProvider(),
        businessService
    )

    @Test
    fun `getBusinesses returns list of businesses upon success`() {
        runBlocking {
            // Given

            // When
            whenever(businessService.getBusinesses(any(), any())).doReturn(
                Response(
                    total = 1,
                    region = Region(),
                    businesses = listOf(
                        Business()
                    )
                )
            )
            val result = businessRepository.getBusinesses("Los Angeles")

            // Then
            result shouldBeInstanceOf Success::class
            verify(businessService, times(1)).getBusinesses(any(), any())
        }
    }

    @Test
    fun `getBusinesses on http exception returns failure`() {
        runBlocking {
            // Given

            // When
            whenever(businessService.getBusinesses(any(), any())).thenThrow(
                HttpException(
                    retrofit2.Response.error<Response>(
                        404, ResponseBody.create(null, "")
                    )
                )
            )
            val result = businessRepository.getBusinesses("Los Angeles")

            // Then
            result shouldBeInstanceOf Failure::class
            verify(businessService, times(1)).getBusinesses(any(), any())
        }
    }

}