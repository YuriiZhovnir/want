package com.example.wanttoeatkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.tool_bar.*


class Search : BaseFragment() {
    companion object {
        const val TAG = "Search"
        fun newInstance() = Search()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        show_search.visibility = View.GONE
        logo_toolbar.visibility = View.GONE
        user.visibility = View.GONE
        search.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
        backButton.setOnClickListener{
            activity?.supportFragmentManager?.popBackStack()

        }
    }
}