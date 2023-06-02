package com.example.interviewtest

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.interviewtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ListAdapter
    private lateinit var mainList: List<MainItem>
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setData()

        val imageCarouselAdapter = ImageCarouselAdapter(mainList)


        binding.imageCarousel.adapter = imageCarouselAdapter
        binding.imageCarousel.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.imageCarousel.offscreenPageLimit = 1

        // Initialize list and adapter
        adapter = ListAdapter(mainList[0].item)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Handle search input
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        binding.imageCarousel.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // This method will be called when a new page is selected
                // You can perform actions based on the selected page
                // For example, update UI elements or perform additional logic
                adapter.updateItem(mainList[position].item)
            }

            override fun onPageScrollStateChanged(state: Int) {
                // This method will be called when the scroll state changes
                // The state can be ViewPager2.SCROLL_STATE_IDLE, ViewPager2.SCROLL_STATE_DRAGGING, or ViewPager2.SCROLL_STATE_SETTLING
                // You can perform actions based on the scroll state
                // For example, enable/disable certain functionality during scrolling
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // This method will be called when the page is being scrolled
                // You can perform actions based on the current scroll position
                // For example, update UI elements or animate views
            }
        })


    }

    private fun setData(): List<MainItem> {


        this.mainList = mainItemList

        return mainList
    }
}