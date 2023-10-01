package com.myapplication.obittechgui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CameraFragment: Fragment()  {
lateinit var view1:View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view1=inflater.inflate(R.layout.camera_fragment, container, false)
        return view1
    }
}