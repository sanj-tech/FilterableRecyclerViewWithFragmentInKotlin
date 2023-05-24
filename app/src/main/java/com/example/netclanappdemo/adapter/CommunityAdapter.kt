package com.example.netclanappdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.netclanappdemo.R
import com.example.netclanappdemo.model.CommunityModel

class CommunityAdapter (ctx: Context, leaveList: ArrayList<CommunityModel>) : ArrayAdapter<CommunityModel>(ctx, 0, leaveList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent);
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent);
    }

    fun createItemView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val list = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.custom_community_spinner_item,
            parent,
            false
        )
        list?.let {
            view.findViewById<TextView>(R.id.communityType).text = (list.communityType)

        }
        return view
    }
}