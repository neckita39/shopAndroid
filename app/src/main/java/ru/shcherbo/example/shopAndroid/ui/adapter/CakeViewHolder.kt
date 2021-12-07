package ru.shcherbo.example.shopAndroid.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.shcherbo.example.shopAndroid.R
import ru.shcherbo.example.shopAndroid.BR
import ru.shcherbo.example.shopAndroid.databinding.ItemCakeVhBinding
import com.squareup.picasso.Picasso


internal class CakeViewHolder(private val binding: ItemCakeVhBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cake: CakeViewModel){
        binding.apply {
            setVariable(BR.viewModel, cake)
            cakeName.text = "Название: ${cake.cake.name.toString()}"
            cakePrice.text = "Цена: ${cake.cake.price.toString()} рублей"
            cakeWeight.text = "Вес: ${cake.cake.weight.toString()} грамм"
            cakeCalories.text = "Калорийность: ${cake.cake.calories.toString()} ккал."
            Picasso.get()
                .load("http://192.168.1.95:8080/${cake.cake.image}")
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
                .into(cakeImg)
        }
    }
}