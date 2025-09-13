package com.example.recyclerviewapiapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewapiapplication.model.ContributorModel

class RecyclerAdapter(private val data: List<ContributorModel>, private val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerlayout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(data[position].avatarUrl)
            .into(holder.imageView)
        holder.loginView.text = buildString {
            append("Developer Name:  ")
            append(data[position].login)
        }
        holder.contributorView.text = buildString {
        append("Total Commits: ")
        append(data[position].contributions)
    }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recyclerImage)
        val loginView: TextView = itemView.findViewById(R.id.login)
        val contributorView: TextView = itemView.findViewById(R.id.contributors)
    }

}

