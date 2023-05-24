package com.example.netclanappdemo.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.UserDetailsAdapter
import com.example.netclanappdemo.databinding.FragmentUserDetailBinding
import com.example.netclanappdemo.model.ExploreModel


class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailBinding
    var userList: MutableList<ExploreModel> = mutableListOf()
    lateinit var userDetailAdapter: UserDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showUserListData()
        filterList()
    }

    private fun filterList() {
        var filter = requireView().findViewById<ImageView>(R.id.ivFilter)
        filter.setOnClickListener({
            var intent = Intent(context, FilterActivity::class.java)
            startActivity(intent)
        })
    }

    private fun showUserListData() {
        userList = ArrayList()
        userDetailAdapter = UserDetailsAdapter(requireContext(), userList)
        binding.userRv.adapter = userDetailAdapter


        userList.clear()
        userList.add(
            ExploreModel(
                "+INVITE",
                "Tushar Patil",
                R.drawable.person_image_four,
                "Pune,within 400-500 m",
                "Fresher | 0Years of experience",
                "Hi Community!.I am available at Your Service!I am Vinit Agrawal completed my Graduation Lorem IpsumDolor Ait AmetnLorem Ipsum"
            )
        )
        userList.add(
            ExploreModel(
                "+INVITE",
                "Mr.Rehana",
                R.drawable.person_image_three,
                "Pune,within 400-500 m",
                "Fresher | 0Years of experience",
                "Hi Community!.I am available at Your Service!I am Vinit Agrawal completed my Graduation Lorem IpsumDolor Ait AmetnLorem Ipsum"
            )
        )
        userList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Pune,within 400-500 m",
                "Fresher | 0Years of experience",
                "Hi Community!.I am available at Your Service!I am Vinit Agrawal completed my Graduation Lorem IpsumDolor Ait AmetnLorem Ipsum"
            )
        )
        userList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Pune,within 400-500 m",
                "Fresher | 0Years of experience",
                "Hi Community!.I am available at Your Service!I am Vinit Agrawal completed my Graduation Lorem IpsumDolor Ait AmetnLorem Ipsum"
            )

        )
        HandleFilter()
    }

    private fun HandleFilter() {
               binding.edtSearch.isFocusableInTouchMode = true
  binding.edtSearch.requestFocus()
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                try {
                    if (::userDetailAdapter.isInitialized) {
                        if (count < before) {
                            userDetailAdapter.resetData()
                        }
                        Log.e("filter", s.toString())
                        userDetailAdapter.filter.filter(s.toString())
                    }
                } catch (e: NullPointerException) {
                    e.printStackTrace()
                }

            }

            override fun afterTextChanged(s: Editable) {}
        })

        // Add remove button in Edit text
        binding.edtSearch.setOnTouchListener { _: View?, motionEvent: MotionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (binding.edtSearch.compoundDrawables[2] != null)
                    if (motionEvent.x >= binding.edtSearch.right - binding.edtSearch.left - binding.edtSearch.compoundDrawables[2].bounds.width()
                    ) {
                        binding.edtSearch.setText("")
                    }
            }
            false
        }
    }

    }


