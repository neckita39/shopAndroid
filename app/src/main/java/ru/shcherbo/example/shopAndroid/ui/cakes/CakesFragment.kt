package ru.shcherbo.example.shopAndroid.ui.cakes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import ru.shcherbo.example.shopAndroid.databinding.FragmentCakeList1Binding
import ru.shcherbo.example.shopAndroid.ui.adapter.CakeAdapter

class CakesFragment : Fragment() {
    private lateinit var binding: FragmentCakeList1Binding
    private val cakeAdapter = CakeAdapter()
    private val cakesViewModel: CakesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCakeList1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cakeList.apply {
            adapter = cakeAdapter
            layoutManager = GridLayoutManager(context,1)
        }

        cakesViewModel.getCakes().observe(viewLifecycleOwner){
            cakeAdapter.reload(it)
        }

    }
}