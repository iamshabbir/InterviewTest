package com.example.interviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.interviewtest.databinding.CarouselItemBinding

class ImageCarouselAdapter(private val images: List<MainItem>) :
    RecyclerView.Adapter<ImageCarouselAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val carouselItemBinding =
            CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(carouselItemBinding)

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageResId = images[position]
        holder.imageView.setImageResource(imageResId.int)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(carouselItemBinding: CarouselItemBinding) :
        RecyclerView.ViewHolder(carouselItemBinding.root) {
        val imageView = carouselItemBinding.imageView
    }
}
