package ru.shcherbo.example.shopAndroid.services

import retrofit2.Response
import ru.shcherbo.example.shopAndroid.data.receivedItems.GetCakesListBack

internal class CakesService(
    private val apiService: CakesServiceApi
) {

    suspend fun getCakes(): Response<GetCakesListBack> = apiService.getCakes()
}