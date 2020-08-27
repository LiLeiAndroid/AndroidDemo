package com.demo.androiddemo

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    private lateinit var mockMainActivity: MainContract.IView

    private val injector : DependencyInjector = StubDependencyInjector()

    private var presenter: MainPresenter? = null

    @Before
    fun setUp() {
        presenter = MainPresenter(mockMainActivity,injector)
    }

    @Test
    fun fetchData() {
        presenter?.fetchData()
        verify(mockMainActivity).showData(DataBean("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""))
    }


}

class StubDependencyInjector: DependencyInjector{
    override fun dataRepository(): DataRepository {
        return StubDataRepository()
    }
}

class StubDataRepository : DataRepository{
    override fun loadData(): DataBean? {
        val dataBean = DataBean("","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","")
        return  dataBean
    }

}