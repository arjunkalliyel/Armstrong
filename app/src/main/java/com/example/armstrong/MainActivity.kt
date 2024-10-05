package com.example.armstrong

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var btnCheck: TextView
    private lateinit var etNum: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        btnCheck = findViewById(R.id.btnCheck)
        etNum = findViewById(R.id.etNum)

        btnCheck.setOnClickListener {
            val n = etNum.text.toString().length
            val num = etNum.text.toString().toInt()
            var temp = num
            var result = 0

            while (temp != 0) {
                val remainder = temp % 10

                result += (remainder.toDouble().pow(n.toDouble())).toInt()

                temp /= 10
            }
            if (result == num) {
                val dialogView: View
                val builder: AlertDialog = AlertDialog.Builder(this).create()
                val inflater = this.layoutInflater
                dialogView = inflater.inflate(R.layout.armstrong_popup, null)
                builder.setCanceledOnTouchOutside(false)
                builder.setCancelable(false)
                builder.setView(dialogView)
                builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                builder.window!!.setGravity(Gravity.BOTTOM)
                val status_info = dialogView.findViewById<TextView>(R.id.tv_status)
                val close_btn = dialogView.findViewById<TextView>(R.id.tv_close_button)
                val status_img = dialogView.findViewById<ImageView>(R.id.iv_image)
                status_info.setText("Armstrong Number")
                status_img.setImageResource(R.drawable.tick_icon_svg)
                close_btn.setOnClickListener { view: View? -> builder.dismiss() }
                builder.show()
            } else {
                val dialogView: View
                val builder: AlertDialog = AlertDialog.Builder(this).create()
                val inflater = this.layoutInflater
                dialogView = inflater.inflate(R.layout.armstrong_popup, null)
                builder.setCanceledOnTouchOutside(false)
                builder.setCancelable(false)
                builder.setView(dialogView)
                builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                builder.window!!.setGravity(Gravity.BOTTOM)
                val status_info = dialogView.findViewById<TextView>(R.id.tv_status)
                val close_btn = dialogView.findViewById<TextView>(R.id.tv_close_button)
                val status_img = dialogView.findViewById<ImageView>(R.id.iv_image)
                status_info.setText("Not an Armstrong Number")
                status_img.setImageResource(R.drawable.red_x_icon)
                close_btn.setOnClickListener { view: View? -> builder.dismiss() }
                builder.show()
            }
        }
    }
}