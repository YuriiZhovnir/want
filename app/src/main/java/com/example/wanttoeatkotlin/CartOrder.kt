package com.example.wanttoeatkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import butterknife.OnClick
import kotlinx.android.synthetic.main.item_alert_done_order.view.*
import kotlinx.android.synthetic.main.item_alert_user.view.*
import kotlinx.android.synthetic.main.item_alert_user.view.close_alert
import kotlinx.android.synthetic.main.tool_bar.*

class CartOrder : BaseFragment() {
    companion object {
        const val TAG = "CartOrder"
        fun newInstance() = CartOrder()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.cart_order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logo_toolbar.visibility = View.GONE
        user.visibility = View.GONE
        search.visibility = View.GONE
        show_search.visibility = View.VISIBLE
        text_toolbar.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
        text_toolbar.setText("ОФОРМЛЕННЯ ЗАМОВЛЕННЯ")
    }
    @OnClick(R.id.send_order)
    fun sendOrder(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.item_alert_done_order, null)
        val mBuilder = AlertDialog.Builder(requireContext())
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()
        mDialogView.close_alert.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}