package com.example.netclanappdemo.view

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.CommunityAdapter
import com.example.netclanappdemo.model.CommunityModel
import com.google.android.material.slider.Slider


class RefineFragment : Fragment() {
    var currentCommunityStatus: String = ""
    var isActive = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_refine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        getStatusData()
        getSliderData()
        getSpinnerData()
        moveToExplore()
        visiblityStatus()


    }

    private fun visiblityStatus() {
        val business = requireView().findViewById<Button>(R.id.btnBusiness)
        val coffee = requireView().findViewById<Button>(R.id.btnCoffee)
        val hobbies = requireView().findViewById<Button>(R.id.btnHobbies)
        val friendship = requireView().findViewById<Button>(R.id.btnFriendship)
        val movies = requireView().findViewById<Button>(R.id.btnMovies)
        val dinning = requireView().findViewById<Button>(R.id.btnDinning)
        val datting = requireView().findViewById<Button>(R.id.btnDatting)
        val matrimony = requireView().findViewById<Button>(R.id.btnMatrimony)

        coffee.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(coffee)
        }

        business.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(business)
        }
        hobbies.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(hobbies)
        }
        friendship.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(friendship)
        }
        movies.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(movies)
        }
        dinning.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(dinning)
        }
        datting.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(datting)
        }
        matrimony.setOnClickListener {
            isActive = !isActive // Toggle active status
            updateButtonAppearance(matrimony)
        }
//        var business = requireView().findViewById<Button>(R.id.btnBusiness)
//        var coffee = requireView().findViewById<Button>(R.id.btnCoffee)
//        coffee.setOnClickListener {
//            isActive = !isActive // Toggle active status
//            updateButtonAppearance()
//        }
//        //Bussiness
//        business.setOnClickListener({
//

//            isActive=!isActive
//            updateBusinessButtonAppearance()
//        })

    }

    private fun updateButtonAppearance(button: Button?) {
        val backgroundRes = if (isActive) R.drawable.button_background else R.drawable.common_btn_bg
        val textColor = if (isActive) Color.BLACK else Color.WHITE

        button!!.setBackgroundResource(backgroundRes)
        button!!.setTextColor(textColor)
    }
//
//    private fun updateBusinessButtonAppearance() {
//        var business = requireView().findViewById<Button>(R.id.btnBusiness)
//        if (isActive) {
//            business.setBackgroundResource(R.drawable.common_btn_bg)
//          business.setTextColor(Color.WHITE)
//            // Perform any other necessary updates for the active state
//        } else {
//            business.setBackgroundResource(R.drawable.button_background)
//          business.setTextColor(Color.CYAN)
//            // Perform any other necessary updates for the inactive state
//        }
//    }
//
//    private fun updateButtonAppearance() {
//        var coffee = requireView().findViewById<Button>(R.id.btnCoffee)
//        if (isActive) {
//            coffee.setBackgroundResource(R.drawable.common_btn_bg)
//            coffee.setTextColor(Color.WHITE)
//            // Perform any other necessary updates for the active state
//        } else {
//            coffee.setBackgroundResource(R.drawable.button_background)
//         coffee.setTextColor(Color.CYAN)
//            // Perform any other necessary updates for the inactive state
//        }
//    }


    private fun moveToExplore() {
        var moveToExplore = requireView().findViewById<Button>(R.id.btnSaveExplore)
        moveToExplore.setOnClickListener {
            val exploreFragment = ExploreFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.container, exploreFragment)
            transaction.addToBackStack(null) // Optional: Add to back stack to enable back navigation
            transaction.commit()
        }
    }

    private fun getSpinnerData() {

        var spinner = requireView().findViewById<Spinner>(R.id.spinner)


        val communityList = arrayListOf<CommunityModel>()


        communityList.add(CommunityModel("Available |Hey Let Us Connect"))
        communityList.add(CommunityModel("Away|Stay Discreet And watch"))
        communityList.add(CommunityModel("Busy|Do Not Disturb|Will Catch Up Later/"))
        communityList.add(CommunityModel("SOS|Emergency!Need Assistance!Help"))


        val adapter = context?.let {
            CommunityAdapter(
                it,
                communityList
            )
        }


        spinner.adapter = adapter

        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                p1: View?,
                position: Int,
                p3: Long
            ) {

                currentCommunityStatus = communityList[position].communityType
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        })

        adapter!!.notifyDataSetChanged()
    }

    private fun getSliderData() {
        var slider = requireView().findViewById<Slider>(R.id.slider)
        slider.addOnChangeListener { slider, value, fromUser ->
            val intValue = value.toInt()
            slider.value = intValue.toFloat()
        }
    }

    private fun getStatusData() {
        var status = requireView().findViewById<EditText>(R.id.etStatus)
        var tvStatus = requireView().findViewById<TextView>(R.id.tvCountStatus)
        status.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Update the character count TextView
                val numChars = s?.length ?: 0
                tvStatus.text = getString(R.string.character_count, numChars)
            }

            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })
    }


}