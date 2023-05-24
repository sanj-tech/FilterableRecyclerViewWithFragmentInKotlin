package com.example.netclanappdemo.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentController
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.CommunityDetailsAdapter
import com.example.netclanappdemo.adapter.ExploreAdapter
import com.example.netclanappdemo.databinding.FragmentCommunityBinding
import com.example.netclanappdemo.databinding.FragmentNetworkBinding
import com.example.netclanappdemo.model.ExploreModel


class CommunityFragment : Fragment() {
    private lateinit var binding: FragmentCommunityBinding
    var communityList: MutableList<ExploreModel> = mutableListOf()
    lateinit var communityDetailsAdapter: CommunityDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCommunityBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
       // return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showNetworkListData()
        filterList()
    }

    private fun filterList() {

        var filter = requireView().findViewById<ImageView>(R.id.ivFilter)
        filter.setOnClickListener({
            var intent = Intent(context, FilterActivity::class.java)
            startActivity(intent)
        })
    }


    private fun showNetworkListData() {
       communityList = ArrayList()
        communityDetailsAdapter = CommunityDetailsAdapter(requireContext(), communityList)
        binding.communityRv.adapter = communityDetailsAdapter


        communityList.clear()
      communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
       communityList.add(
            ExploreModel(
                "+INVITE",
                "Siago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
     communityList.add(
            ExploreModel(
                "+INVITE",
                "Piago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
      communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
       communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
     communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
        communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
        communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
       communityList.add(
            ExploreModel(
                "+INVITE",
                "Diago Maradona",
                R.drawable.person_image,
                "Ascochinga within 80.2KM",
                "Friendship | Coffee | Hangout",
                "Hi Community! I am open to new Connections."
            )
        )
        HandleFilter()
    }

    private fun HandleFilter() {
        binding.etCommunitySearch.isFocusableInTouchMode = true
        binding.etCommunitySearch.requestFocus()
        binding.etCommunitySearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                try {
                    if (::communityDetailsAdapter.isInitialized) {
                        if (count < before) {
                            communityDetailsAdapter.resetData()
                        }
                        Log.e("filter", s.toString())
                        communityDetailsAdapter.filter.filter(s.toString())
                    }
                } catch (e: NullPointerException) {
                    e.printStackTrace()
                }

            }

            override fun afterTextChanged(s: Editable) {}
        })

        // Add remove button in Edit text
        binding.etCommunitySearch.setOnTouchListener { _: View?, motionEvent: MotionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP) {
                if (binding.etCommunitySearch.compoundDrawables[2] != null)
                    if (motionEvent.x >= binding.etCommunitySearch.right - binding.etCommunitySearch.left - binding.etCommunitySearch.compoundDrawables[2].bounds.width()
                    ) {
                        binding.etCommunitySearch.setText("")
                    }
            }
            false
        }
    }


}
