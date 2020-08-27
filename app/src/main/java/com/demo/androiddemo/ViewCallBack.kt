package com.demo.androiddemo

/**
* @author FrankWang
* @time 2020/8/27 3:44 PM
*/
class ViewCallBack private constructor(){

    companion object{
        private var instance:ViewCallBack? = null
        get() {
            if (field == null){
                field = ViewCallBack()
            }
            return field
        }
        fun get():ViewCallBack{
            return instance!!
        }
    }

    interface CountDownListener {
        fun countDown()
    }

    private var mListener:CountDownListener?=null

    fun setListener(listener:CountDownListener){
        mListener = listener
    }

    fun countDown() {
        mListener?.countDown()
    }
}