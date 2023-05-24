package com.example.netclanappdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.ExploreAdapter
import com.example.netclanappdemo.databinding.FragmentNetworkBinding
import com.example.netclanappdemo.model.ExploreModel


class NetworkFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_network, container, false)




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    //handle

//    private fun handleFilter() {
//       binding.etSearch.isFocusableInTouchMode = true
//  binding.etSearch.requestFocus()
//        binding.etSearch.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//                try {
//                    if (::exploreAdapter.isInitialized) {
//                        if (count < before) {
//                            exploreAdapter.resetData()
//                        }
//                        Log.e("filter", s.toString())
//                        exploreAdapter.filter.filter(s.toString())
//                    }
//                } catch (e: NullPointerException) {
//                    e.printStackTrace()
//                }
//
//            }
//
//            override fun afterTextChanged(s: Editable) {}
//        })
//
//        // Add remove button in Edit text
//        binding.etSearch.setOnTouchListener { _: View?, motionEvent: MotionEvent ->
//            if (motionEvent.action == MotionEvent.ACTION_UP) {
//                if (binding.etSearch.compoundDrawables[2] != null) {
//                    if (motionEvent.x >= binding.etSearch.right - binding.etSearch.left - binding.etSearch.compoundDrawables[2].bounds.width()
//                    ) {
//                        binding.etSearch.setText("")
//                    }
//                }
//            }
//            false
//        }
//    }


}
