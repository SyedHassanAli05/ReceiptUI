package com.myapplication.obittechgui

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class BottomNavAdaptor (var mData: ArrayList<BottomNavItemModel>, var mContext: Context,
                        var callBackSelected: (prePosition: Int, selectedPost: Int, item: BottomNavItemModel) -> Unit
) :
    RecyclerView.Adapter<BottomNavAdaptor.BottomItemVH>() {
    var selected: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomItemVH {
        return BottomItemVH(LayoutInflater.from(mContext).inflate(R.layout.item_btn, parent, false))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: BottomItemVH, position: Int) {
        val item = mData[position]
        //holder.imgView.setImageResource(item.icon ?: 0)
        holder.title.text=item.title

        if (selected == position) {
            holder.imgView.setImageResource(item.iconSelected!!)
            holder.title.setTextColor(mContext.getColor(item.colorSelected ?: 0))
        } else {
            holder.imgView.setImageResource(item.icon!!)
            holder.title.setTextColor(mContext.getColor(item.color ?: 0))
        }
        holder.itemView.setOnClickListener {
            val prePos = selected
            selected = position
            notifyItemChanged(position)
            notifyItemChanged(prePos)
            callBackSelected.invoke(prePos, selected, item)
        }
        if(position==1){
            holder.imgView.visibility=View.GONE
            holder.title.visibility=View.GONE
        }
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    class BottomItemVH(item: View) : RecyclerView.ViewHolder(item) {

        val imgView: ImageView =itemView.findViewById(R.id.ivBtm)
        val title: TextView = itemView.findViewById(R.id.tvBtm)
    }



}
