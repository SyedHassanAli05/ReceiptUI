package com.myapplication.obittechgui

import android.app.Activity
import android.app.AlertDialog
import android.app.appsearch.AppSearchSchema
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.obittechgui.utlis.LocalPreferance

class HomeFragment:Fragment() {

    lateinit var view1: View
    lateinit var logout: TextView
    lateinit var DrawerToggle: ActionBarDrawerToggle
    lateinit var imageView: ImageView
    lateinit var drawerLayout: DrawerLayout
    lateinit var contactus: TextView
    lateinit var home_filter: ImageView
    lateinit var yes: TextView
    lateinit var no: TextView
    lateinit var cancel:ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.activity_home_screen_drawer, container, false)
        findView()
        onClickListner()


        DrawerToggle = ActionBarDrawerToggle(
            requireContext() as Activity?,
            drawerLayout,
            R.string.nav_open,
            R.string.nav_close
        )
        drawerLayout.addDrawerListener(DrawerToggle)
        DrawerToggle.syncState()

        val recycleList = view1.findViewById<RecyclerView>(R.id.recycleList)
        recycleList.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.HORIZONTAL,
            false
        ).apply { recycleList.layoutManager = this }
        val arrayReceipt = ArrayList<ReceiptHorizontalModel>()
        arrayReceipt.add(ReceiptHorizontalModel(R.drawable.frame, "Receipt Title1", "Jan26,2022", "06:30PM"))
        arrayReceipt.add(ReceiptHorizontalModel(R.drawable.frame, "Receipt Title2", "Jan26,2022", "06:30PM"))
        arrayReceipt.add(ReceiptHorizontalModel(R.drawable.frame, "Receipt Title3", "Jan26,2022", "06:30PM"))
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title4",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title5",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title6",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title7",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title8",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title9",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title10",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title11",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title12",
                "Jan26,2022",
                "06:30PM"
            )
        )
        arrayReceipt.add(
            ReceiptHorizontalModel(
                R.drawable.frame,
                "Receipt Title13",
                "Jan26,2022",
                "06:30PM"
            )
        )

        val adaptor = ReceiptHorizontalAdaptor()
        adaptor.set_Data(arrayReceipt)
        recycleList.adapter = adaptor

        return view1
    }

    private fun findView() {
        imageView = view1.findViewById(R.id.drawer_menu)
        contactus = view1.findViewById(R.id.contact_us)
        home_filter = view1.findViewById(R.id.filter_icon)
        drawerLayout = view1.findViewById(R.id.home_drawer)
        logout = view1.findViewById(R.id.logout)
       // pref = requireContext().getSharedPreferences(pref_name, Context.MODE_PRIVATE)



    }

    private fun checkDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun onClickListner() {
        imageView.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)

        }

        contactus.setOnClickListener {

            val intent = Intent(requireContext(), ContactUsActivity::class.java)
            startActivity(intent)
        }

        home_filter.setOnClickListener {
            val intent = Intent(requireContext(), FilterActivity::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {

            val view = View.inflate(requireContext(), R.layout.dialog_card,null)
            val builder = AlertDialog.Builder(requireContext(), R.style.RoundedCornersDialog)
            builder.setView(view)
            yes = view.findViewById(R.id.dialog_yes)
            no = view.findViewById(R.id.dialog_no)
            cancel = view.findViewById(R.id.cancel)

            val dialog = builder.create()
            dialog.show()

            yes.setOnClickListener {

                LocalPreferance.shared.clear()
                /*if (pref.getBoolean(Is_Login, true)) {
                    val editor: SharedPreferences.Editor = pref.edit()
                    editor.clear();
                    editor.apply();*/
                    val intent = Intent(requireContext(), Login::class.java)
                    startActivity(intent)
                   activity?.finishAffinity()

                }
            no.setOnClickListener {
                dialog.dismiss()
            }
            cancel.setOnClickListener {
                dialog.dismiss()
            }

        }

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (DrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}


