package com.example.bitcoinpricebrowser.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bitcoinpricebrowser.R
import com.example.bitcoinpricebrowser.viewmodel.MyViewModel
import com.example.bitcoinpricebrowser.viewmodel.MyViewModel.Companion.CLICK
import com.example.libraries.utils.ChartUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myViewModel by lazy {
        ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            myViewModel.fetchPrice()
        }

        myViewModel.prices.observe(this, Observer {
            ChartUtils.notifyDataSetChanged(chart, it)
        })

        ChartUtils.initChart(chart)

        fab.setOnClickListener {
            val snackbarDelete = Snackbar.make(coordinatorLayout,
                myViewModel.message, Snackbar.LENGTH_LONG)
                .setAction(CLICK) {
                    myViewModel.fetchPrice()
                }
            snackbarDelete.show()
        }
    }
}
