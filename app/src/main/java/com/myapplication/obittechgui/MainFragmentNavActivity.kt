package com.myapplication.obittechgui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragmentNavActivity : AppCompatActivity() {
  lateinit var rvItem: RecyclerView
  lateinit var scan_btn: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_nav)
        supportFragmentManager.beginTransaction().replace(R.id.flFragment,HomeFragment()).commit()

        rvItem=findViewById(R.id.rvBottoms)
        scan_btn=findViewById(R.id.scan_btn)

        scan_btn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.flFragment,CameraFragment()).commit()
        }

        var itemsBtm = arrayListOf<BottomNavItemModel>(
            BottomNavItemModel(
                R.drawable.hom,
                R.drawable.home,
                "Home",
                android.R.color.white,
                android.R.color.white,
            ),
            BottomNavItemModel(

                R.drawable.folder2,
                R.drawable.folder,
                "Saved",
                android.R.color.white,
                android.R.color.white,
            ),
            BottomNavItemModel(

                R.drawable.folder2,
                R.drawable.folder,
                "Saved",
                android.R.color.white,
                android.R.color.white,
            )

        )

        rvItem.adapter = BottomNavAdaptor(itemsBtm, this)
        { prePosition: Int, selectedPost: Int, item: BottomNavItemModel ->

            if(selectedPost==0) {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment, HomeFragment()).commit()
            }
            else if(selectedPost==2)
            {
                supportFragmentManager.beginTransaction().replace(R.id.flFragment,SavedFragment()).commit()
                true
            }



        }



    }
}