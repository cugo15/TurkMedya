package com.example.turkmedya.ui.adapter

import android.text.Html
import androidx.recyclerview.widget.RecyclerView
import com.example.turkmedya.databinding.NewsDetailItemBinding
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.utils.downloadUrl
import com.example.turkmedya.utils.placeHolderProgressBar

class NewsDetailViewHolder (val binding: NewsDetailItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(filteredNews: FilteredNews) {
        val category = filteredNews.category.title.lowercase().replaceFirstChar { it.uppercase() }
        val htmlText = "Anasayfa > $category > <b>${filteredNews.title}</b>"
        binding.txtTitle.text = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
        binding.imageView.downloadUrl(filteredNews.imageUrl, placeHolderProgressBar(binding.root.context))
        binding.txtHeader.text = filteredNews.title
        binding.txtDescription.text = filteredNews.shortText
        binding.txtDate.text = filteredNews.publishDate
    }
}