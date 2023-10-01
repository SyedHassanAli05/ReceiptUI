package com.myapplication.obittechgui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView


class ReceiptDetailActivity : AppCompatActivity() {
    lateinit var rd_back:ImageView
   lateinit var title:TextView
    lateinit var date:TextView
    lateinit var time:TextView
    lateinit var receipt_img:ImageView

    var receiptObj:ReceiptModel ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt_detail)

        receiptObj = intent.getSerializableExtra("receiptObj") as ReceiptModel


       // Log.d("dataReceipt", receiptObj.rTitle)





        findView()
        onBackPress()
    }

    private fun findView()
    {
        rd_back=findViewById(R.id.rd_backicon)
        title=findViewById(R.id.tvReceiptTitleDetail)
        date=findViewById(R.id.tv_date)
        time=findViewById(R.id.tv_time)
        receipt_img=findViewById(R.id.receipt_image)

        title.setText(receiptObj?.rTitle)
        date.setText(receiptObj?.date)
        time.setText(receiptObj?.time)
        receiptObj?.image?.let { receipt_img.setImageResource(it) }

    }

    private fun onBackPress()
    {
        rd_back.setOnClickListener {
            onBackPressed()
        }
    }

}