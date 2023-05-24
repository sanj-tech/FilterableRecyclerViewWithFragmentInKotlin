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

class ExploreAdapter(var context: Context,var explorList: MutableList<ExploreModel>):
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>(){

    private var filteredExploreList: List<ExploreModel> = explorList
    //private var filteredList: List<ExploreModel> = explorList

//    fun setFilteredList(explorList: MutableList<ExploreModel>){
//        this.explorList=explorList
//        notifyDataSetChanged()
//    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        var binding:CustomRvItemviewBinding=DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.custom_rv_itemview,parent,false)
        return ExploreViewHolder(binding)
    }

//    fun filterList(filterlist: MutableList<ExploreModel>) {
//        // below line is to add our filtered
//        // list in our course array list.
//        explorList = filterlist
//        // below line is to notify our adapter
//        // as change in recycler view data.
//        notifyDataSetChanged()
//    }




    override fun getItemCount(): Int {
     return explorList.size
    }


    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
      var explorList=explorList[position]
        holder.binding.tvInvite.text=explorList.userInvitation
        holder.binding.tvUserName.text=explorList.userName
        holder.binding.ivUserImage.setImageResource(explorList.userImage)
        holder.binding.tvUserDistance.text=explorList.userDistance
        holder.binding.tvSocialType.text=explorList.socialType
        holder.binding.tvUDescription.text=explorList.userDescription


holder.binding.tvInvite.setOnClickListener({
    holder.binding.tvInvite.text="Pending"
})

    }
//    fun filterList(filteredList: List<ExploreModel>) {
//        filteredCourseList = filteredList
//        notifyDataSetChanged()
//    }

    class ExploreViewHolder(val binding: CustomRvItemviewBinding):RecyclerView.ViewHolder(binding.root)

        fun resetData() {
            filteredExploreList = explorList
        }



//    override fun getFilter(): Filter {
//        return object : Filter() {
//            @SuppressLint("NotifyDataSetChanged")
//            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
//                filteredExploreList = filterResults.values as List<ExploreModel>
//                notifyDataSetChanged()
//            }
//
//            override fun performFiltering(charSequence: CharSequence?): FilterResults {
//                val enteredString = charSequence?.toString()?.toLowerCase(Locale.getDefault())
//
//                val filterResults = FilterResults()
//                filterResults.values = if (enteredString == null || enteredString.isEmpty())
//                    explorList
//                else
//                    explorList.filter {
//                        it.userName!!.toLowerCase(Locale.getDefault())
//                            .contains(enteredString) || it.socialType!!.toLowerCase(Locale.getDefault())
//                            .contains(enteredString)
//                    }
//                return filterResults
//            }
//        }
//    }

//    interface OnClick {
//        fun onClick(position: Int)
//    }
}