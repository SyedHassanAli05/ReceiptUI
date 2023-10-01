package com.myapplication.obittechgui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReceiptHorizontalAdaptor():RecyclerView.Adapter<ReceiptHorizontalAdaptor.ViewHolder> (){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReceiptHorizontalAdaptor.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycleview_receipt_horizontal,parent,false)
        return ReceiptHorizontalAdaptor.ViewHolder(view)
    }

    lateinit var arrayReceipt:ArrayList<ReceiptHorizontalModel>
    fun set_Data(listView: ArrayList<ReceiptHorizontalModel>){
        arrayReceipt=listView
    }


    override fun onBindViewHolder(holder:ReceiptHorizontalAdaptor.ViewHolder, position: Int) {
        holder.im_View.setImageResource(arrayReceipt[position].image)
        holder.txtView_title.text=arrayReceipt[position].rTitle
        holder.txtview_date.text=arrayReceipt[position].date
        holder.txtview_time.text=arrayReceipt[position].time
    }

    override fun getItemCount(): Int {
        return arrayReceipt.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val im_View: ImageView =itemView.findViewById(R.id.im_View)
        val txtView_title: TextView = itemView.findViewById(R.id.txtView_title)
        val txtview_date: TextView =itemView.findViewById(R.id.txtview_date)
        val txtview_time: TextView =itemView.findViewById(R.id.txtview_time)
    }
}