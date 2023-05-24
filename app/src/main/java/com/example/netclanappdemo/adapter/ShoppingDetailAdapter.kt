package com.example.netclanappdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanappdemo.R
import com.example.netclanappdemo.databinding.CustomShoppingItemviewBinding
import com.example.netclanappdemo.model.ExploreModel

class ShoppingDetailAdapter(var context:Context,var shoppingList: MutableList<ExploreModel>): RecyclerView.Adapter<ShoppingDetailAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        var binding:CustomShoppingItemviewBinding=DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.custom_shopping_itemview,parent,false)
        return ShoppingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var shoppingList=shoppingList[position]

        holder.binding.tvInvite.text=shoppingList.userInvitation
        holder.binding.tvUserName.text=shoppingList.userName
        holder.binding.ivUserImage.setImageResource(shoppingList.userImage)
        holder.binding.tvUserDistance.text=shoppingList.userDistance
        holder.binding.tvSocialType.text=shoppingList.socialType
        holder.binding.tvUDescription.text=shoppingList.userDescription
    }

    class ShoppingViewHolder(var binding:CustomShoppingItemviewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}