package com.demo.androiddemo
/**
* @author FrankWang
* @time 2020/8/27 11:41 AM
*/
interface MainContract {

    interface IView:IBaseView<IPresenter>{
        fun showData(data:DataBean?)
    }

    interface IPresenter :IBasePresenter {
        fun fetchData()
    }
}