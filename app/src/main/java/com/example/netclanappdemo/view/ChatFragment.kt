package com.example.netclanappdemo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.netclanappdemo.R
import com.example.netclanappdemo.adapter.ExploreAdapter
import com.example.netclanappdemo.databinding.FragmentChatBinding
import com.example.netclanappdemo.model.ExploreModel


class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatBinding.inflate(LayoutInflater.from(context))
        val view: View = binding.root

        return view
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_chat, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    }


