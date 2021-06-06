package com.example.gdsc_app_mobile

import android.content.Context
import android.graphics.Typeface
import android.provider.Settings.Global.getString
import android.util.Base64
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.gdsc_app_mobile.fragments.FragmentContact
import com.example.gdsc_app_mobile.models.TokenInfoModel
import com.google.gson.Gson

class HelperClass {
    companion object {
        fun String.deserializeTokenInfo(): TokenInfoModel {
            val gson = Gson()
            val tokenInfo = gson.fromJson(this, TokenInfoModel::class.java)
            Singleton.setTokenInfo(tokenInfo)
            return tokenInfo
        }
        fun String.decodeBase64(): String {
            return Base64.decode(this, Base64.DEFAULT).decodeToString()
        }
        fun setToolbarStyle(context: Context?, toolbar: Toolbar, fragment: String){
            val textView = toolbar.findViewById<TextView>(R.id.toolbar_title)
            val layout = toolbar.findViewById<RelativeLayout>(R.id.toolbar_title_layout)
            when (fragment) {
                "about_us" -> {
                    textView.text = context?.getString(
                        R.string.FragmentAboutUsTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY

                }
                "articles" -> {
                    textView.text = context?.getString(
                        R.string.FragmentArticlesTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY
                }
                "contact" -> {
                    textView.text = context?.getString(
                        R.string.FragmentContactTitle)
                    textView.typeface = Typeface.DEFAULT_BOLD
                    textView.textSize = 23f
                    layout.gravity = Gravity.CENTER or Gravity.BOTTOM
                }
                "faq" -> {
                    textView.text = context?.getString(
                        R.string.FragmentArticlesTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY
                }
                "options" -> {
                    textView.text = context?.getString(
                        R.string.FragmentOptionsTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY
                }
                "suggestions" -> {
                    textView.text = context?.getString(
                        R.string.FragmentSuggestionsTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY
                }
                "teams" -> {
                    textView.text = context?.getString(
                        R.string.FragmentTeamsTitle)
                    textView.typeface = Typeface.DEFAULT
                    textView.textSize = 15f
                    layout.gravity = Gravity.NO_GRAVITY
                }
            }

        }
    }

}