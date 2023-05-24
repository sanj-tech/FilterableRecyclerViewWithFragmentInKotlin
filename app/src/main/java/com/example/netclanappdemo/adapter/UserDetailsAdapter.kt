package com.example.netclanappdemo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanappdemo.R
import com.example.netclanappdemo.databinding.CustomUserDetailsBinding
import com.example.netclanappdemo.model.ExploreModel
import java.util.*

class UserDetailsAdapter(var context: Context, var userDetailList: MutableList<ExploreModel>) :
    RecyclerView.Adapter<UserDetailsAdapter.UserViewHolder>(), Filterable {
    private var newFilteredUserList: List<ExploreModel> = userDetailList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var binding: CustomUserDetailsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_user_details, parent, false
        )
        return UserViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return newFilteredUserList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var userList = newFilteredUserList[position]
        holder.binding.tvInvite.text = userList.userInvitation
        holder.binding.tvUserName.text = userList.userName
        holder.binding.ivUserImage.setImageResource(userList.userImage)
        holder.binding.tvUserDistance.text = userList.userDistance
        holder.binding.tvSocialType.text = userList.socialType
        holder.binding.tvUDescription.text = userList.userDescription
    }

    class UserViewHolder(val binding: CustomUserDetailsBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun resetData() {
        newFilteredUserList = userDetailList

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
                newFilteredUserList = filterResults.values as List<ExploreModel>
                notifyDataSetChanged()
            }

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val enteredString = charSequence?.toString()?.toLowerCase(Locale.getDefault())

                val filterResults = FilterResults()
                filterResults.values = if (enteredString == null || enteredString.isEmpty())
                    userDetailList
                else
                    userDetailList.filter {
                        it.userName!!.toLowerCase(Locale.getDefault())
                            .contains(enteredString) || it.userDescription!!.toLowerCase(Locale.getDefault())
                            .contains(enteredString)
                    }
                return filterResults
            }
        }
    }
}