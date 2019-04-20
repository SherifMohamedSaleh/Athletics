package com.example.movie

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide

class MyAdapter(internal var context: Context, private val dataList: List<MovieAthlete> ,val clickListener: (MovieAthlete) -> Unit) :
    RecyclerView.Adapter<MyAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.movie_layout, viewGroup, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, i: Int) {
        customViewHolder.txtname?.setText(dataList[i].name + "")
        Glide.with(context).load(dataList[i].image).into(customViewHolder.imageView)
        customViewHolder.click(context, dataList[i],clickListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class CustomViewHolder(val myView: View) : RecyclerView.ViewHolder(myView) {
        var txtname: TextView
        var imageView: ImageView


        init {
            txtname = myView.findViewById(R.id.textView)
            imageView = myView.findViewById(R.id.imageView)


        }
        fun click(context: Context, movie: MovieAthlete, clickListener: (MovieAthlete) -> Unit) {
            itemView.setOnClickListener { clickListener(movie)}
        }
    }


}
