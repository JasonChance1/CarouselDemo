package com.example.carouseldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carouseldemo.databinding.ActivityMainBinding
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        binding.recyclerView.layoutManager = CarouselLayoutManager()
        val icons = listOf(
            R.drawable.img,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            )
        val adapter = CarouselAdapter(this,icons)


        binding.recyclerView.adapter = adapter

        // Hero Strategy,突出中间的item
        val carouselLayoutManager = CarouselLayoutManager(HeroCarouselStrategy())
        binding.heroStrategyRecyclerview.layoutManager = carouselLayoutManager
        binding.heroStrategyRecyclerview.adapter = adapter

        // 捕获需要突出的item，不用将需要突出的item滑动到正中心，捕获后会自动将突出项显示到中心
        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(binding.heroStrategyRecyclerview)


//        // 全屏
//        binding.fullScreenRecyclerView.layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy(), RecyclerView.VERTICAL)
    }
}