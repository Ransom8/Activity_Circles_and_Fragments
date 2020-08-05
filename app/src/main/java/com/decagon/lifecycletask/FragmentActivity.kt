package com.decagon.lifecycletask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_activity_layout.*

class FragmentActivity : AppCompatActivity() {

    //delayed but promising to initialize fragmentTransaction
    private lateinit var fragmentTransaction : FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity_layout)

        /*
            Button triggers for adding fragment on top stack and
            removing topmost fragment from top of stack
        */

        btn_add_fragment.setOnClickListener{
            addFragment()
        }

        btn_remove_fragment.setOnClickListener{
            if(supportFragmentManager.backStackEntryCount == 0) {
                //Return to main activity if stack is empty
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                //Remove Fragment at the top
                supportFragmentManager.popBackStack()
            }
        }

    }


    private fun addFragment() {
        var fragment: Fragment

        //get the fragment position on stack
        var stackPosition = supportFragmentManager.backStackEntryCount

        var fragmentBundle = Bundle()

        //Transfer data to fragment class using Bundle
        fragmentBundle.putInt("STACK_POSITION", stackPosition + 1)

        when(stackPosition) {
            0 -> {
                fragment = FragmentClass()
                fragment.setArguments(fragmentBundle)
            }
            1 -> {
                fragment = FragmentClassTwo()
                fragment.setArguments(fragmentBundle)
            }
            2 -> {
                fragment = FragmentClassThree()
                fragment.setArguments(fragmentBundle)
            }
            else -> return
        }

        //Setting fragment Transaction via fragment support manager class
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}

