package com.example.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pagination.Adapter.WallpapersAdapter
import com.example.pagination.Api.ApiInterface
import com.example.pagination.Api.Apiclient
import com.example.pagination.Model.PhotosItem
import com.example.pagination.Model.SearchWallpaperModel
import com.example.pagination.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallpapersAdapter
    var list = ArrayList<PhotosItem>()
    var page = 1
    lateinit var search: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
    }

    private fun initView() {

        binding.imgSearch.setOnClickListener {
            search = binding.edtSearch.text.toString()

            CallApi(search, page)


        }
        binding.nestedScroll.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                // in this method we are incrementing page number,
                // making progress bar visible and calling get data method.
                page++
                binding.progressBar.setVisibility(View.VISIBLE)
                CallApi(search, page)
            }
        })
    }

private fun CallApi(search:String,page1:Int){
    var apiInterface=Apiclient.getApiClient().create(ApiInterface::class.java)
    apiInterface.getWallpaper(search,page1.toString(),Apiclient.KEY)
        .enqueue(object:Callback<SearchWallpaperModel>{
            override fun onResponse(
                call: Call<SearchWallpaperModel>,
                response: Response<SearchWallpaperModel>
            ) {
                list.addAll(response.body()?.photos as ArrayList<PhotosItem>)
                adapter = WallpapersAdapter(list)
                binding.wallpaperList.layoutManager = GridLayoutManager(this@MainActivity,3)
                binding.wallpaperList.adapter = adapter
                binding.progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<SearchWallpaperModel>, t: Throwable) {

            }

        })

}


}

