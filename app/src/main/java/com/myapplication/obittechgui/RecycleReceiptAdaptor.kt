package com.myapplication.obittechgui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleReceiptAdaptor (val callBack: (position: Int, item: ReceiptModel) -> Unit): RecyclerView.Adapter<RecycleReceiptAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleReceiptAdaptor.ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.receipt_row,parent,false)
        return ViewHolder(view)
    }
    lateinit var arrReceipt:ArrayList<ReceiptModel>
    fun setData(list:ArrayList<ReceiptModel>){
        arrReceipt=list
    }

    override fun onBindViewHolder(holder: RecycleReceiptAdaptor.ViewHolder, position: Int) {

        holder.imgView.setImageResource(arrReceipt[position].image)
        holder.rTitle.text=arrReceipt[position].rTitle
        holder.txt_date.text=arrReceipt[position].date
        holder.txt_time.text=arrReceipt[position].time


        holder.itemView.setOnClickListener {
            callBack(position,arrReceipt[position])
        }
    }

    override fun getItemCount(): Int {
        return arrReceipt.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val imgView: ImageView=itemView.findViewById(R.id.imgView)
        val rTitle: TextView = itemView.findViewById(R.id.rTitle)
        val txt_date: TextView=itemView.findViewById(R.id.txt_date)
        val txt_time: TextView=itemView.findViewById(R.id.txt_time)
    }
}