package com.example.netclanappdemo.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.CommunityAdapter
import com.example.netclanappdemo.databinding.ActivityFilterBinding
import com.example.netclanappdemo.model.CommunityModel

class FilterActivity : AppCompatActivity() {
    var currentCommunityStatus: String = ""
    lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter)

        showSlideData()
        getSpinnerData()
    }

    private fun getSpinnerData() {


        val filterList = arrayListOf<CommunityModel>()


        filterList.add(CommunityModel("Wine Shop"))
        filterList.add(CommunityModel("Shoes & Accessories"))
        filterList.add(CommunityModel("Multi Brand Store"))
        filterList.add(CommunityModel("Chemist & Drugist"))
        filterList.add(CommunityModel("Restaurants & Cofffee Shop"))
        filterList.add(CommunityModel("Saloon"))
        filterList.add(CommunityModel("Chemist & Drugist"))
        filterList.add(CommunityModel("Restaurants & Cofffee Shop"))
        filterList.add(CommunityModel("Saloon"))
        val adapter = CommunityAdapter(
            this,
            filterList
        )


        binding.filterSpinner.adapter = adapter

        binding.filterSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                p1: View?,
                position: Int,
                p3: Long
            ) {

                currentCommunityStatus = filterList[position].communityType
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        })

        adapter!!.notifyDataSetChanged()
    }

    private fun showSlideData() {


        binding.rangeSlider.addOnChangeListener { slider, value, fromUser ->
            val intValue = value.toInt()
            slider.setMinSeparationValue(intValue.toFloat())

        }
    }
}
