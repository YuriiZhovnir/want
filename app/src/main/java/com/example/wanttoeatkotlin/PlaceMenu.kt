package com.example.wanttoeatkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import butterknife.OnClick
import kotlinx.android.synthetic.main.item_alert_order.view.*
import kotlinx.android.synthetic.main.item_alert_user.view.*
import kotlinx.android.synthetic.main.item_alert_user.view.close_alert
import kotlinx.android.synthetic.main.item_info_place.*
import kotlinx.android.synthetic.main.tool_bar.*

class PlaceMenu : BaseFragment() {
    companion object {
        const val TAG = "PlaceMenu"
        const val NAME_SHOW = "name_show"
        fun newInstance(name_show: String) = PlaceMenu().apply {
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
        return inflater?.inflate(R.layout.place_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logo_toolbar.visibility = View.GONE
        user.visibility = View.GONE
        search.visibility = View.GONE
        show_search.visibility = View.VISIBLE
        text_toolbar.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
        namePlaceInItem.visibility = View.GONE

        text_toolbar.setText(arguments?.getString(PlacesInfo.NAME_SHOW))
    }

    @OnClick(R.id.backButton)
    fun backButton() {
        activity?.supportFragmentManager?.popBackStack()
    }
    @OnClick(R.id.order)
    fun getOrder(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.item_alert_order, null)

        val mBuilder = context?.let {
            AlertDialog.Builder(it)
                .setView(mDialogView)
        }

        val mAlertDialog = mBuilder?.show()

        mDialogView.close_alert.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }
}