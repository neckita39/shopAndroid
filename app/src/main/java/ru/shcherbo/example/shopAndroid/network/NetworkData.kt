package ru.shcherbo.example.shopAndroid.network

import ru.shcherbo.example.shopAndroid.model.Cake
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkData(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val cakesService = AppNetwork.cakesService

    suspend fun cakesList(): List<Cake> = withContext(defaultDispatcher){
        val response = cakesService.getCakes()
        val cakeList = if(response.isSuccessful){
            response.body()?.cake_list ?: listOf()
        } else listOf()

        cakeList.map{
            with(it){ Cake(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble()) }
        }
    }

}