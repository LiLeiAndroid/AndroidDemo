package com.demo.androiddemo
/**
* @author FrankWang
* @time 2020/8/27 12:06 PM
*/
class MainPresenter(view:MainContract.IView,injector:DependencyInjector):MainContract.IPresenter{

    private val dataRepository:DataRepository = injector.dataRepository()

    private var view:MainContract.IView? = view

    override fun fetchData() {
        loadData()
    }

    override fun onDestroy() {
        this.view = null
    }

    private fun loadData(){
        val data = dataRepository.loadData()
        view?.showData(data)
    }
}