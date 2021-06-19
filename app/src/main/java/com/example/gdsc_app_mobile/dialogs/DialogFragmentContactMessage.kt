package com.example.gdsc_app_mobile.dialogs

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.gdsc_app_mobile.R
import com.example.gdsc_app_mobile.interfaces.ISelectedDataContact

class DialogFragmentContactMessage : DialogFragment() {

    private lateinit var switchDarkMode: SwitchCompat

    lateinit var listener: ISelectedDataContact
    lateinit var submit: Button
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var subject: EditText
    lateinit var message: EditText
    lateinit var img : ImageView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.dialog_contact_message, container,false)
        //set background transparent
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        name = view.findViewById(R.id.contactNameEditText)
        email = view.findViewById(R.id.contactEmailEditText)
        subject = view.findViewById(R.id.contactSubjectEditText)
        message = view.findViewById(R.id.contactMessageEditText)
        img = view.findViewById(R.id.img_add_event)
        switchDarkMode = view.findViewById(R.id.switch_dark_mode)

        submit = view.findViewById(R.id.contactSubmitMessageButton)
        submit.setOnClickListener {
            listener.onSelectedData(name.text.toString(), email.text.toString(), subject.text.toString(), message.text.toString())
            dialog?.dismiss()
        }

        backgroundNightCheck()

        return view
    }

    //method to add the listener from the fragment in which the dialog is called
    fun addListener(listener: ISelectedDataContact){
        this.listener = listener
    }

    private fun backgroundNightCheck(){

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            img.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
    }
}