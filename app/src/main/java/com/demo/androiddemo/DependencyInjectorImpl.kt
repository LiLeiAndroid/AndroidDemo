package com.demo.androiddemo
/**
* @author FrankWang
* @time 2020/8/27 11:05 AM
*/
class DependencyInjectorImpl : DependencyInjector {
    override fun dataRepository() : DataRepository {
        return DataRepositoryImpl()
    }
}