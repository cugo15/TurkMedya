package com.example.turkmedya.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.turkmedya.databinding.NewsItemBinding
import com.example.turkmedya.domain.model.FilteredNews

class NewsAdapter(
    private val newsList: List<FilteredNews>,

    private val onItemClick: (FilteredNews) -> Unit,
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }

    // Adapter'deki toplam item sayısını döndür
    override fun getItemCount(): Int = newsList.size

    // Her bir ViewHolder için veriyi bağlamak için çağrılır
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNewsItem = newsList[position]
        // ViewHolder'ı bağla ve gerekli callback'leri geçir
        holder.bind(currentNewsItem,onItemClick)
    }
}