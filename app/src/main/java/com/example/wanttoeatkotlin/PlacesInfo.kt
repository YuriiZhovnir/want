package com.example.wanttoeatkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.OnClick
import kotlinx.android.synthetic.main.tool_bar.*
import kotlinx.android.synthetic.main.want_to_eat.*

class PlacesInfo : BaseFragment() {
    companion object {
        const val TAG = "PlacesInfo"
        const val NAME_SHOW = "name_show"
        fun newInstance(name_show: String) = PlacesInfo().apply {
            arguments = Bundle(3).apply {
                putString(NAME_SHOW, name_show)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.places_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logo_toolbar.visibility = View.GONE
        user.visibility = View.GONE
        search.visibility = View.GONE
        show_search.visibility = View.VISIBLE
        text_toolbar.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
        text_toolbar.setText(arguments?.getString(NAME_SHOW))

    }

    @OnClick(R.id.go_to_menu_fragment)
    fun goToFragmentMenu() {
        val fragment = PlaceMenu.newInstance(name_show = "Назва ресторану")
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, fragment, PlaceMenu.TAG)
            ?.addToBackStack(fragment::class.java.name)
            ?.commit()
    }

    @OnClick(R.id.backButton)
    fun backButton() {
        activity?.supportFragmentManager?.popBackStack()
    }
}
