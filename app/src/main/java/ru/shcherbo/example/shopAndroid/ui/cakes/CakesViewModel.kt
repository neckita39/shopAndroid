package ru.shcherbo.example.shopAndroid.ui.cakes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ru.shcherbo.example.shopAndroid.App
import ru.shcherbo.example.shopAndroid.network.NetworkData
import kotlinx.coroutines.launch
import ru.shcherbo.example.shopAndroid.ui.adapter.CakeViewModel

class CakesViewModel(application: Application) : AndroidViewModel(application) {
    private val cakes: MutableLiveData<List<CakeViewModel>> = MutableLiveData()
    private val storageNetData = NetworkData();

    init{
        loadCakes()
    }

    fun getCakes(): LiveData<List<CakeViewModel>> {
        return cakes
    }
    private fun loadCakes(){
        viewModelScope.launch {
            cakes.postValue(storageNetData.cakesList().map { CakeViewModel(getApplication<App>(), it) })
        }
    }
}