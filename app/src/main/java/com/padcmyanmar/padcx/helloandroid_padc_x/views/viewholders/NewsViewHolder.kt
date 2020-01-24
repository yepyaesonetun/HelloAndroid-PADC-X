package com.padcmyanmar.padcx.helloandroid_padc_x.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcmyanmar.padcx.helloandroid_padc_x.delegates.NewsItemDelegate

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-17.
 */

class NewsViewHolder(itemView: View, delegate: NewsItemDelegate) :
    NewsBaseViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            delegate.onTapNewsItem()
        }
    }
}