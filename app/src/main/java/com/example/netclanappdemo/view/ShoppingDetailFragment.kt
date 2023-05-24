package com.example.netclanappdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.ShoppingDetailAdapter
import com.example.netclanappdemo.databinding.FragmentShoppingDetailBinding
import com.example.netclanappdemo.model.ExploreModel


class ShoppingDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoppingDetailBinding
    var shoppingList: MutableList<ExploreModel> = mutableListOf()
    lateinit var shoppingDetailAdapter: ShoppingDetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingDetailBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showShoppingListData()
    }

    private fun showShoppingListData() {
        shoppingList = ArrayList()
        shoppingDetailAdapter = ShoppingDetailAdapter(requireContext(), shoppingList)
        binding.userRv.adapter = shoppingDetailAdapter


        shoppingList.clear()
        shoppingList.add(
            ExploreModel(
                "",
                "Rohan Patil",
                R.drawable.contact_image_one,
                "Ravet within 5.8 KM",
                "Hi Community! We have great deals for You.\\nCheck us out!!\"\n",
                " Video arcade"
            )
        )
        shoppingList.add(
            ExploreModel(
                "",
                "Mr.Rehana",
                R.drawable.contact_image_two,
                "Pune,within 400-500 m",
                "Hi Community! We have great deals for You.\\nCheck us out!!\"\n",
                "Video arcade"
            )
        )
        shoppingList.add(
            ExploreModel(
                "",
                "Diago Maradona",
                R.drawable.contact_image_three,
                "Pune,within 400-500 m",
                "Hi Community! We have great deals for You.\\nCheck us out!!\"\n",
                "Video arcade"
            )
        )
        shoppingList.add(
            ExploreModel(
                "",
                "Diago Maradona",
                R.drawable.contact_image_three,
                "Pune,within 400-500 m",
                "Hi Community! We have great deals for You.\\nCheck us out!!\"\n",
                "Video arcade"
            )
        )
        shoppingList.add(
            ExploreModel(
                "",
                "Diago Maradona",
                R.drawable.contact_image_three,
                "Pune,within 400-500 m",
                "Hi Community! We have great deals for You.\\nCheck us out!!\"\n",
                "Video arcade"
            )
        )
    }
}