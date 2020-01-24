package com.padcmyanmar.padcx.helloandroid_padc_x.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.helloandroid_padc_x.R
import com.padcmyanmar.padcx.helloandroid_padc_x.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.helloandroid_padc_x.views.viewholders.NewsBaseViewHolder
import com.padcmyanmar.padcx.helloandroid_padc_x.views.viewholders.NewsSmallViewHolder
import com.padcmyanmar.padcx.helloandroid_padc_x.views.viewholders.NewsViewHolder

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-17.
 */

class NewsAdapter(val delegate: NewsItemDelegate) : RecyclerView.Adapter<NewsBaseViewHolder>() {

    val VIEW_TYPE_ONE = 11223
    val VIEW_TYPE_TWO = 11200

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsBaseViewHolder {

        when (viewType) {
            VIEW_TYPE_ONE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, delegate)
            }
            VIEW_TYPE_TWO -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news_small, parent, false)
                return NewsSmallViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news_small, parent, false)
                return NewsSmallViewHolder(view)
            }
        }

    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun getItemViewType(position: Int): Int {
        when {
            position % 3 == 0 -> {
                return VIEW_TYPE_ONE
            }
            else -> {
                return VIEW_TYPE_TWO
            }
        }
    }

    override fun onBindViewHolder(holder: NewsBaseViewHolder, position: Int) {

    }
}