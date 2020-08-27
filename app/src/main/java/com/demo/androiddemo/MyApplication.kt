package com.demo.androiddemo

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Message
import java.util.*

/**
 * @author FrankWang
 * @time 2020/8/27 3:46 PM
 */
class MyApplication : Application() {
    private var mContext: Context? = null
    private val mTimer = Timer()

    val COUNT_DOWN = 0x1000
    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext

        val appHandler: Handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    COUNT_DOWN -> ViewCallBack.get().countDown()
                    else -> {
                    }
                }
            }
        }

        val mTimerTask: TimerTask = object : TimerTask() {
            override fun run() {
                appHandler.sendEmptyMessage(COUNT_DOWN)
            }
        }

        mTimer.schedule(mTimerTask, 1000, 1000)
    }
}