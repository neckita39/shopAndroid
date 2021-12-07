package ru.shcherbo.example.shopAndroid.ui.adapter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.shcherbo.example.shopAndroid.model.Cake


class CakeViewModel(application: Application, val cake: Cake) : AndroidViewModel(application){}