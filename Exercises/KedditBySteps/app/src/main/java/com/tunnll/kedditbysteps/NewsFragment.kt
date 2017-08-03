package com.tunnll.kedditbysteps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.news_fragment.*
import android.view.ViewGroup
import com.tunnll.kedditbysteps.commons.inflate

class NewsFragment : Fragment() {
    private var newsList: RecyclerView by lazy {
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = container?.inflate(R.layout.news_fragment)
        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)

        return view
    }
}
