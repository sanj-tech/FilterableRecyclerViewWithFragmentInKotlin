package com.example.netclanappdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.ViewPagerAdapter
import com.example.netclanappdemo.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayout


class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentExploreBinding
//    var exploreList: MutableList<ExploreModel> = mutableListOf()
//    lateinit var exploreAdapter: ExploreAdapter
//

//    private fun filterList(query: String?) {
//        if (query != null) {
//            val filteredList = ArrayList<ExploreModel>()
//            for (i in exploreList) {
//                if (i.userName.lowercase(Locale.ROOT).contains(query)) {
//                    filteredList.add(i)
//                }
//            }
//            if (filteredList.isEmpty()) {
//                Toast.makeText(context, "No data found", Toast.LENGTH_LONG).show()
//            } else {
//                exploreAdapter.setFilteredList(filteredList)
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUPTab()
        // filterList()
        //showExploreListData()
        replaceFragment(NetworkFragment())


//        val editTextSearch = view.findViewById<EditText>(R.id.etSearch)
//        editTextSearch.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                // Not needed for this implementation
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                // Call the filter method with the entered text
//                filters(s.toString())
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                // Not needed for this implementation
//            }
//        })


    }

//    private fun filterList() {
//        var filter = requireView().findViewById<ImageView>(R.id.ivFilter)
//        filter.setOnClickListener({
//            var intent = Intent(context, FilterActivity::class.java)
//            startActivity(intent)
//        })
//    }


    private fun setUPTab() {

        val adapter = ViewPagerAdapter(childFragmentManager)

        adapter.addFragment(CommunityFragment(), "")
        adapter.addFragment(UserDetailFragment(), "")
        adapter.addFragment(ShoppingDetailFragment(), "")
        binding.viewPager.adapter =
            adapter  // Check if the ID is correctly defined in the layout file
        binding.tab.setupWithViewPager(binding.viewPager)
        // binding.exploreRv.visibility=View.GONE//
        binding.tab.getTabAt(0)!!.setIcon(R.drawable.people_icon)
        binding.tab.getTabAt(1)!!.setIcon(R.drawable.mail_box)
        binding.tab.getTabAt(2)!!.setIcon(R.drawable.contact_details)

        // binding.tab.getTabAt(1)!!.setTabLabelVisibility(TAB_LABEL_VISIBILITY_UNLABELED)


        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
//                    var linear = requireView().findViewById<LinearLayout>(R.id.linar)
//                    var net = requireView().findViewById<FrameLayout>(R.id.networkPage)
//                    if (tab.isSelected){
//                     linear.visibility=View.GONE
//                        net.visibility=View.VISIBLE
//                    }

                //Replace the current fragment with the newly selected fragment
                //replaceFragment(adapter.getItem(tab.position))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        // private fun filters(query: String) {
//        val filteredList = exploreList.filter { course ->
//            course.userName.contains(query, ignoreCase = true)
//        }
//        exploreAdapter.filterList(filteredList)


//        val filteredList = mutableListOf<ExploreModel>()
//        for (explore in exploreList) {
//            if (explore.userName.contains(query, ignoreCase = true)) {
//                filteredList.add(explore)
//            }
//        }
//        exploreAdapter.filterList(filteredList)
//    }
    }


    private fun replaceFragment(item: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(
                R.id.myContainer,
                item
            )  // Replace R.id.fragmentContainer with your actual container ID
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
    }


//    private fun showExploreListData() {
//        exploreList = ArrayList()
//        exploreAdapter = ExploreAdapter(requireContext(), exploreList)
//        binding.exploreRv.adapter = exploreAdapter
//
//
//        exploreList.clear()
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Siago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Piago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//        exploreList.add(
//            ExploreModel(
//                "+INVITE",
//                "Diago Maradona",
//                R.drawable.person_image,
//                "Ascochinga within 80.2KM",
//                "Friendship | Coffee | Hangout",
//                "Hi Community! I am open to new Connections."
//            )
//        )
//
//        //exploreAdapter.notifyDataSetChanged()
//
////        val searchView = binding.etSearch
////        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
////            override fun onQueryTextSubmit(query: String?): Boolean {
////                return false
////            }
////
////            override fun onQueryTextChange(newText: String?): Boolean {
////                filter(newText)
////                return true
////            }
////        })
////    }
////
////    private fun filter(text: String?) {
////        val filteredList = exploreList.filter { explore ->
////            explore.userName.contains(text ?: "", ignoreCase = true)
////        }
////     exploreAdapter.filterList(ArrayList(filteredList))
////        binding.exploreRv.adapter = exploreAdapter
////
////    }
////
////    override fun onDestroyView() {
////        super.onDestroyView()
////        _binding = null
////    }
//
//
//
//
//    }
}

