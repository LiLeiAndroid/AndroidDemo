package com.demo.androiddemo
/**
*
* @author FrankWang
* @time 2020/8/26 6:00 PM
*/
interface IBaseView<T> {
    fun setPresenter(presenter:T)
}