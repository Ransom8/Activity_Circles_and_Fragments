package com.decagon.lifecycletask

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var activityCycle = "onCreate()"
    private var landscapeCount = 0
    private var portraitCount = 1

    //Handler initializer
    var handler = Handler()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //delay and display onCreate method
        delayOnCreate()

        //Get saved Instance state
        getInstanceState(savedInstanceState)

        //Intent for fragment activity
        fragment_activity.setOnClickListener{
            startActivity(Intent(this, FragmentActivity::class.java))
        }
    }


    private fun delayOnCreate() {
        var run = Runnable {
            displayActivityState("onCreate")
        }

        handler.postDelayed(run, 1200)
    }

    //getInstance function
    private fun getInstanceState(savedInstanceState: Bundle?) {
        //Object instance of device orientation
        val orientation = resources.configuration.orientation

        //Check for saved instance state
        if (savedInstanceState != null) {

            //Retrieving the saved Instance states
            activityCycle = savedInstanceState.getString("ACTIVITY_CYCLE").toString()


            landscapeCount = savedInstanceState.getInt("LANDSCAPE_CONTA")
            portraitCount = savedInstanceState.getInt("PORTRAIT_CONTA")

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                // In landscape
                landscapeCount++
                orientation_count.text = "LANDSCAPE $landscapeCount"
            } else {
                // In portrait
                portraitCount++
                orientation_count.text = "PORTRAIT $portraitCount"
            }

        }
    }

    override fun onRestart() {
        super.onRestart()
        var run = Runnable {
            displayActivityState("onRestart()")
        }

        handler.postDelayed(run, 1600)
    }

    override fun onStart() {
        super.onStart()
        var run = Runnable {
            displayActivityState("onStart()")
        }

        handler.postDelayed(run, 1800)
    }

    override fun onResume() {
        super.onResume()
        var run = Runnable {
            displayActivityState("onResume()")
        }

        handler.postDelayed(run, 2400)
    }

    override fun onPause() {
        super.onPause()

        var run = Runnable {
            displayActivityState("onPause()")
        }

        handler.postDelayed(run, 2800)
    }

    override fun onStop() {
        super.onStop()

        var run = Runnable {
            displayActivityState("onStop()")
        }

        handler.postDelayed(run, 1200)
    }


    private fun displayActivityState(str : String) {
        activityCycle = str
        activity_state.text = activityCycle
    }

    //Saved Instance State
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("ACTIVITY_CYCLE", activityCycle)
        outState.putInt("LANDSCAPE_CONTA", landscapeCount)
        outState.putInt("PORTRAIT_CONTA", portraitCount)

    }


}

