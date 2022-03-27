package com.example.blogapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.blogapp.R
import com.example.blogapp.data.model.Post
import com.example.blogapp.databinding.FragmentHomeScreenBinding
import com.example.blogapp.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(
            Post("https://unsplash.com/photos/OhKElOkQ3RE", "Daniel Garcia", Timestamp.now(), "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pokemon.com%2Fes%2F&psig=AOvVaw2F6sGTygMp58kNnmQFeuBI&ust=1648502580927000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCICjh-uc5_YCFQAAAAAdAAAAABAD" )
        )

        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }
}