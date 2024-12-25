package com.example.turkmedya.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.turkmedya.databinding.NewsItemBinding
import com.example.turkmedya.domain.model.FilteredNews
import com.example.turkmedya.utils.downloadUrl
import com.example.turkmedya.utils.placeHolderProgressBar

class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir FilteredNews nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        filteredNews: FilteredNews,
        crossinline onClickListener: (FilteredNews,) -> Unit,
    ) {
       binding.textViewTitle.text = filteredNews.title
        binding.imageViewNews.downloadUrl(filteredNews.imageUrl, placeHolderProgressBar(binding.root.context))
        binding.textViewDescription.text = filteredNews.shortText
        binding.textViewPublishedDate.text = filteredNews.publishDate
        binding.textViewCategory.text = filteredNews.category.title
        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, diğer fragmenta gönderilecek nesneyi dışarı yolla
            onClickListener(filteredNews)
        }
    }
}