package com.tunnll.kedditbysteps.commons

import com.tunnll.kedditbysteps.commons.adapter.AdapterConstants
import com.tunnll.kedditbysteps.commons.adapter.ViewType

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}