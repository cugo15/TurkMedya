package com.example.turkmedya.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.turkmedya.databinding.NewsDetailItemBinding
import com.example.turkmedya.domain.model.FilteredNews

class NewsDetailAdapter(
    private val newsList: Array<FilteredNews>, // FilteredNews nesnelerinin bulunduğu liste
) : RecyclerView.Adapter<NewsDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsDetailItemBinding.inflate(inflater, parent, false)
        return NewsDetailViewHolder(binding)
    }

    // Adapter'deki toplam item sayısını döndür
    override fun getItemCount(): Int = newsList.size

    // Her bir ViewHolder için veriyi bağlamak için çağrılır
    override fun onBindViewHolder(holder: NewsDetailViewHolder, position: Int) {
        val currentNewsItem = newsList[position]
        // ViewHolder'ı bağla ve gerekli callback'leri geçir
        holder.bind(currentNewsItem)
    }
}