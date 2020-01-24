package com.padcmyanmar.padcx.helloandroid_padc_x

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.helloandroid_padc_x.adapters.NewsAdapter
import com.padcmyanmar.padcx.helloandroid_padc_x.delegates.NewsItemDelegate
import kotlinx.android.synthetic.main.activity_news_list.*

class NewsListActivity : AppCompatActivity(), NewsItemDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        setSupportActionBar(toolbar)
        toolbar.title = resources.getString(R.string.tool_bar_title_news_list)

        val rvAdapter = NewsAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this)


//        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

//        val gridLayoutManager = GridLayoutManager(this,2)

//        val staggeredGridLayoutManager =
//            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


        rvNews.layoutManager = linearLayoutManager
        rvNews.adapter = rvAdapter

    }

    override fun onTapNewsItem() {
        startActivity(NewsDetailActivity.newIntent(this))
    }
}
