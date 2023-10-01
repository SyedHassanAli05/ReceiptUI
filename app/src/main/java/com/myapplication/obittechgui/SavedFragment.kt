package com.myapplication.obittechgui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SavedFragment : Fragment() {
    lateinit var sr_filter:ImageView
    lateinit var view1: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        view1=inflater.inflate(R.layout.activity_saved_receipt, container, false)
      //  override fun onCreate(savedInstanceState: Bundle?)

            findView()
            onClickListner()

            val recyclerList = view1.findViewById<RecyclerView>(R.id.recyclerList)
            recyclerList.layoutManager = LinearLayoutManager(requireContext())
            val arrReceipt = ArrayList<ReceiptModel>()

            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title", "Feb26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 1", "March26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 2", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.scan, "Receipt Title 3", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 4", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 5", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 6", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 7", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 8", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 9", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 10", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 11", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 12", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))
            arrReceipt.add(ReceiptModel(R.drawable.phone, "Receipt Title 13", "Jan26,2022", "06:30PM","Lorem ispum de vaitl"))



            val adaptor = RecycleReceiptAdaptor() { position, item ->
                //Toast.makeText(applicationContext,item.rTitle,Toast.LENGTH_LONG).show()\
                val intent=Intent(requireContext(),ReceiptDetailActivity::class.java)
                intent.putExtra("receiptObj", item)
                startActivity(intent)
            }
            adaptor.setData(arrReceipt)
            recyclerList.adapter = adaptor

        return view1
    }

    private fun findView() {

        sr_filter=view1.findViewById((R.id.sr_filter))
    }

    private fun onClickListner()
    {
        sr_filter.setOnClickListener {
            val intent=Intent(requireContext(),FilterActivity::class.java)
            startActivity(intent)
        }
    }



    }

