package com.example.blogapp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogapp.core.BaseViewHolder
import com.example.blogapp.data.model.Post
import com.example.blogapp.databinding.PostItemViewBinding

class HomeScreenAdapter(private val postList: List<Post>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    // Crear cada uno de los posts
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder) {
            is HomeScreenViewHolder -> holder.bind(postList[position])
        }
    }

    // Retorna la cantidad de items(posts)
    override fun getItemCount(): Int = postList.size

    private inner class HomeScreenViewHolder(val bindind: PostItemViewBinding, val context: Context): BaseViewHolder<Post>(bindind.root){
        override fun bind(item: Post) {
            Glide.with(context).load(item.post_image).centerCrop().into(bindind.postImage)
            Glide.with(context).load(item.profile_picture).centerCrop().into(bindind.profilePicture)
            bindind.profileName.text = item.profile_name
            bindind.postTimestamp.text = "Hace 2 horas"
        }
    }
}