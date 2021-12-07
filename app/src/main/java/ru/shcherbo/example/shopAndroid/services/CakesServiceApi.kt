package ru.shcherbo.example.shopAndroid.services

import retrofit2.Response
import retrofit2.http.GET
import ru.shcherbo.example.shopAndroid.data.receivedItems.GetCakesListBack

internal interface CakesServiceApi {

    @GET("cakes")
    suspend fun getCakes(): Response<GetCakesListBack>

}