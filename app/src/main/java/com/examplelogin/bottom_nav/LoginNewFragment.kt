package com.examplelogin.bottom_nav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class LoginNewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_login_new,container,false)
        val button=view.findViewById(R.id.btn1) as CardView
        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v:View){
                when(v.getId()){
                    R.id.btn1 -> {
                        val intent1 = Intent(view.getContext(), LoginActivity::class.java)
                        startActivity(intent1)
                }}
            }
        })
            return view
    }
}

