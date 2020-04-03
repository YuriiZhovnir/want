package com.example.wanttoeatkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import butterknife.OnClick
import kotlinx.android.synthetic.main.bottom_bar.*

class BottomBar : BaseFragment() {
    companion object {
        const val TAG = "BottomBarFragment"
        const val BOTTOM_BAR = "name_tool_bar"
        fun newInstance(name_bottom_bar: String) = BottomBar().apply {
            arguments = Bundle(3).apply {
                putString(BOTTOM_BAR, name_bottom_bar)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater?.inflate(R.layout.bottom_bar, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataOrder = 0
//        var name = arguments?.getString(BOTTOM_BAR)
        var name = "1"
        when (name) {
            "0" -> {
                call_tab.visibility = View.VISIBLE
                if (dataOrder == 0) {
                    cart_empty_tab.visibility = View.VISIBLE
                    cart_tab.visibility = View.GONE
                } else {
                    cart_tab.visibility = View.VISIBLE
                    cart_empty_tab.visibility = View.GONE
                }
                info_tab.visibility = View.GONE
                reviews_tab.visibility = View.GONE
                sorting_tab.visibility = View.GONE
                tracking_tab.visibility = View.GONE

            }
            "1" -> {
                call_tab.visibility = View.VISIBLE
                sorting_tab.visibility = View.VISIBLE
                if (dataOrder == 0) {
                    cart_empty_tab.visibility = View.VISIBLE
                    cart_tab.visibility = View.GONE
                } else {
                    cart_tab.visibility = View.VISIBLE
                    cart_empty_tab.visibility = View.GONE
                }
                info_tab.visibility = View.GONE
                reviews_tab.visibility = View.GONE
                tracking_tab.visibility = View.GONE

            }
            "2" -> {
                info_tab.visibility = View.VISIBLE
                reviews_tab.visibility = View.VISIBLE
                if (dataOrder == 0) {
                    cart_empty_tab.visibility = View.VISIBLE
                    cart_tab.visibility = View.GONE
                } else {
                    cart_tab.visibility = View.VISIBLE
                    cart_empty_tab.visibility = View.GONE
                }
                call_tab.visibility = View.GONE
                sorting_tab.visibility = View.GONE
                tracking_tab.visibility = View.GONE

            }
            "3" -> {
                call_tab.visibility = View.GONE
                info_tab.visibility = View.VISIBLE
                reviews_tab.visibility = View.VISIBLE
                sorting_tab.visibility = View.GONE
                tracking_tab.visibility = View.VISIBLE
                cart_empty_tab.visibility = View.GONE
                cart_tab.visibility = View.GONE
            }
            else -> println("Number too high")
        }

    }

    @OnClick(R.id.cart_tab, R.id.cart_empty_tab)
    fun openCart() {
        val fragment = CartPersonalInformation.newInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, fragment, CartPersonalInformation.TAG)
            ?.addToBackStack(fragment::class.java.name)
            ?.commit()
    }

    @OnClick(R.id.call_tab)
    fun callPhone() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+380980071008")
        startActivity(intent)
    }
}

