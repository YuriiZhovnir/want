package com.example.wanttoeatkotlin

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder

open class BaseFragment : Fragment() {
    companion object {

    }

    private var unbinder: Unbinder = Unbinder.EMPTY
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        unbinder = ButterKnife.bind(this, view)
    }

    override fun onDestroyView() {
        hideKeyboard()
        super.onDestroyView()
        unbinder.unbind()
    }

    fun hideKeyboard() {
        try {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(activity?.window?.decorView?.windowToken, 0)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}