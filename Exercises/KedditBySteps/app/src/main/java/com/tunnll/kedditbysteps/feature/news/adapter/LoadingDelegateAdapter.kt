package com.tunnll.kedditbysteps.feature.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.tunnll.kedditbysteps.R
import com.tunnll.kedditbysteps.commons.adapter.ViewType
import com.tunnll.kedditbysteps.commons.adapter.ViewTypeDelegateAdapter
import com.tunnll.kedditbysteps.commons.extensions.inflate


class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading)) {
    }
}