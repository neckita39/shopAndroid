package ru.shcherbo.example.shopAndroid.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.shcherbo.example.shopAndroid.databinding.ItemCakeVhBinding


internal class CakeAdapter : RecyclerView.Adapter<CakeViewHolder>() {

    private var cakes = mutableListOf<CakeViewModel>()

    fun reload(newCakes: List<CakeViewModel>){
        cakes.clear()
        cakes.addAll(newCakes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CakeViewHolder(ItemCakeVhBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.bind(cakes[position])
    }

    override fun getItemCount(): Int = cakes.size
}