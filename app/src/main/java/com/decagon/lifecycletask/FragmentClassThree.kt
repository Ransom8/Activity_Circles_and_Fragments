package com.decagon.lifecycletask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentClassThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Inflate the layout for this fragment
        var view : View = inflater.inflate(R.layout.fragment_layout3, container, false)

        //obtain fragment position on stack from Bundle and save it to Fragment TextView
        var stackPosition = this.arguments!!.getInt("STACK_POSITION")


        var tvText : TextView = view.findViewById(R.id.tvFragPosition)
        tvText.text = "Fragment position: $stackPosition"

        Toast.makeText(
            activity,
            "$stackPosition", Toast.LENGTH_SHORT).show()

        return view
    }
}