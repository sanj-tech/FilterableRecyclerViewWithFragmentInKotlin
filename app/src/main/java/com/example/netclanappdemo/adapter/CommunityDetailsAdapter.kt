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
import com.example.netclanappdemo.databinding.CustomRvItemviewBinding
import com.example.netclanappdemo.model.ExploreModel
import java.util.*

class CommunityDetailsAdapter(var context: Context,var communityList: MutableList<ExploreModel>):
    RecyclerView.Adapter<CommunityDetailsAdapter.CommunityDetailViewHolder>(),Filterable {
    private var communityFilteredList: List<ExploreModel> = communityList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityDetailViewHolder {
        var binding: CustomRvItemviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_rv_itemview,parent,false)
        return CommunityDetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return communityFilteredList.size
    }

    override fun onBindViewHolder(holder: CommunityDetailViewHolder, position: Int) {
        var communityList=communityFilteredList[position]
        holder.binding.tvInvite.text=communityList.userInvitation
        holder.binding.tvUserName.text=communityList.userName
        holder.binding.ivUserImage.setImageResource(communityList.userImage)
        holder.binding.tvUserDistance.text=communityList.userDistance
        holder.binding.tvSocialType.text=communityList.socialType
        holder.binding.tvUDescription.text=communityList.userDescription


        holder.binding.tvInvite.setOnClickListener({
            holder.binding.tvInvite.text="Pending"
        })
    }
    class CommunityDetailViewHolder(var binding: CustomRvItemviewBinding): RecyclerView.ViewHolder(binding.root)
        fun resetData() {
            communityFilteredList = communityList

        }


    override fun getFilter(): Filter {
        return object : Filter() {
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
               communityFilteredList= filterResults.values as List<ExploreModel>
                notifyDataSetChanged()
            }

            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val enteredString = charSequence?.toString()?.toLowerCase(Locale.getDefault())

                val filterResults = FilterResults()
                filterResults.values = if (enteredString == null || enteredString.isEmpty())
                   communityList
                else
                    communityList.filter {
                        it.userName!!.toLowerCase(Locale.getDefault())
                            .contains(enteredString) || it.userDescription!!.toLowerCase(Locale.getDefault())
                            .contains(enteredString)
                    }
                return filterResults
            }
        }
    }
}