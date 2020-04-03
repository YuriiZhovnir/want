package com.example.wanttoeatkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.item_alert_user.view.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.want_to_eat)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.user)
    fun showAlertUser() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.item_alert_user, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()
        mDialogView.email_toolbar.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus == true) {
                mDialogView.line_red_email.visibility = View.VISIBLE
                mDialogView.line_red_phone.visibility = View.GONE

            }
            if (hasFocus) {
                mDialogView.email_toolbar.setHint("")
            } else {
                mDialogView.email_toolbar.setHint("Емаіл")
            }
        }
        mDialogView.phone_toolbar.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus == true) {
                mDialogView.line_red_email.visibility = View.GONE
                mDialogView.line_red_phone.visibility = View.VISIBLE
            }
            if (hasFocus) {
                mDialogView.phone_toolbar.setHint("")
            } else {
                mDialogView.phone_toolbar.setHint("Телефон")
            }
        }
        mDialogView.close_alert.setOnClickListener {
            mAlertDialog.dismiss()
        }
        mDialogView.finish.setOnClickListener {
            val emailValue = mDialogView.email_toolbar.text?.toString()
            val phoneValue = mDialogView.phone_toolbar.text?.toString() ?: ""
            if (true == emailValue.isNullOrEmpty()) {
                mDialogView.email_toolbar?.error =
                    String.format(getString(R.string.error_blank), getString(R.string.email))
                return@setOnClickListener
            } else if (false == Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
                mDialogView.email_toolbar?.error = getString(R.string.not_valid_email)
                return@setOnClickListener
            }
            if (true == phoneValue.isNullOrEmpty()) {
                mDialogView.phone_toolbar?.error =
                    String.format(getString(R.string.error_blank), getString(R.string.phone))
                return@setOnClickListener
            } else if (false == isValidMobile(phoneValue)) {
                mDialogView.phone_toolbar?.error = getString(R.string.not_valid_phone)
                return@setOnClickListener
            }
        }
    }

    private fun isValidMobile(phone: String): Boolean {
        return if (!Pattern.matches("[a-zA-Z]+", phone)) {
            phone.length > 10 && phone.length <= 13
        } else false
    }

    @OnClick(R.id.show_search)
    fun showFragmentSearch() {
        val fragment = Search.newInstance()
        supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, fragment, Search.TAG)
            ?.addToBackStack(fragment::class.java.name)
            ?.commit()
    }

    @OnClick(R.id.go_to_fragment_place)
    fun goToFragmentPlace() {
        val fragment = PlacesInfo.newInstance(name_show = "НАзва категорії")
        supportFragmentManager?.beginTransaction()
            ?.replace(android.R.id.content, fragment, PlacesInfo.TAG)
            ?.addToBackStack(fragment::class.java.name)
            ?.commit()
    }
}
