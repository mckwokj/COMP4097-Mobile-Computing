package com.example.infoday.ui.news

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.infoday.R
import com.example.infoday.data.News

import com.example.infoday.ui.news.dummy.DummyContent.DummyItem
import com.squareup.picasso.Picasso

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class NewsRecyclerViewAdapter(
//    private val values: List<DummyItem>
    private val values: List<News>
) : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_new_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        Picasso.get().load(item.image).into(holder.newsImageView)
        holder.titleTextView.text = item.title
        holder.detailTextView.text = item.detail
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsImageView: ImageView = view.findViewById(R.id.newsImageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val detailTextView: TextView = view.findViewById(R.id.detailTextView)

        override fun toString(): String {
            return super.toString() + " '" + titleTextView.text + "'"
        }
    }
}