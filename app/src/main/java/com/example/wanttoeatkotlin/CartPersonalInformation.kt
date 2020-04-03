package com.example.wanttoeatkotlin

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick
import kotlinx.android.synthetic.main.cart_personal_information.*
import kotlinx.android.synthetic.main.tool_bar.*

class CartPersonalInformation : BaseFragment() {
    companion object {
        const val TAG = "CartPersonalInformation"
        fun newInstance() = CartPersonalInformation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.cart_personal_information, container, false)
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
        number_persons.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus == true){
                line_after_number_persons.setBackgroundResource(R.color.colorPrimary)
            }else{
                line_after_number_persons.setBackgroundResource(R.color.ColorGreyLithe)
            }
        }

//        if (phone.getText().toString().trim().isNullOrEmpty()) {
//
//            phone.setCompoundDrawablesWithIntrinsicBounds(
//                null,
//                null,
//                getResources().getDrawable(R.drawable.ic_ellipse_grey),
//                null
//            )
//        } else {
//            phone.setCompoundDrawablesWithIntrinsicBounds(
//                null,
//                null,
//                resources.getDrawable(R.drawable.ic_ellipse_yelow),
//                null
//            )
//        }
    }

    @OnClick(R.id.go_to_show_order)
    fun goToShowOrder() {
        val fragment = CartOrder.newInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, fragment, CartOrder.TAG)
            ?.addToBackStack(fragment::class.java.name)
            ?.commit()
    }
    @OnClick(R.id.backButton)
    fun backButton() {
        activity?.supportFragmentManager?.popBackStack()
    }

    @OnClick(R.id.then_order)
    fun funThenOrder() {
        then_order.setBackgroundResource(R.color.ColorBlack)
        then_order.setTextColor(resources.getColor(R.color.ColorWith))
        then_order.setTypeface(Typeface.DEFAULT_BOLD)
        for_now.setBackgroundResource(R.drawable.grey_border)
        for_now.setTextColor(resources.getColor(R.color.ColorBlack))
        for_now.setTypeface(Typeface.DEFAULT)
    }

    @OnClick(R.id.for_now)
    fun funTForNow() {
        for_now.setBackgroundResource(R.color.ColorBlack)
        for_now.setTextColor(resources.getColor(R.color.ColorWith))
        for_now.setTypeface(Typeface.DEFAULT_BOLD)
        then_order.setBackgroundResource(R.drawable.grey_border)
        then_order.setTextColor(resources.getColor(R.color.ColorBlack))
        then_order.setTypeface(Typeface.DEFAULT)
    }
}