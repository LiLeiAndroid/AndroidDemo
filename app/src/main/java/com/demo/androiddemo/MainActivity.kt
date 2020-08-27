package com.demo.androiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author FrankWang
 * @time 2020/8/27 11:03 AM
 */
class MainActivity : AppCompatActivity(), MainContract.IView, ViewCallBack.CountDownListener {

    private lateinit var presenter: MainContract.IPresenter
    private var isFirst: Boolean = true//是否第一次加载
    private var fetchNo = 1//请求次数
    private var firstTime:Int = 5//初次倒计时
    private var afterTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCallBack.get().setListener(this)

        setPresenter(MainPresenter(this, DependencyInjectorImpl()))

        refreshLayout.setOnRefreshListener {
            presenter.fetchData()
        }
    }

    override fun showData(data: DataBean?) {
        if (refreshLayout.isRefreshing) {
            refreshLayout.isRefreshing = false
        }
        tvTimeCountDown.visibility = View.GONE
        tvContent.text = data?.toString()
        fetchNo++
    }

    override fun setPresenter(presenter: MainContract.IPresenter) {
        this.presenter = presenter
    }

    override fun countDown() {
        if (isFirst) {
            firstLoad()
        } else {
            afterLoad()
        }
    }

    /**
     * 初次加载，5秒后获取数据
     */
    private fun firstLoad() {
        if (firstTime > 0) {
            firstTime--
            tvTimeCountDown.text = firstTime.toString()
        } else {
            tvTimeCountDown.text = "Loading......"
            presenter.fetchData()
            isFirst = false
        }
    }

    /**
     * 每隔5秒获取一次
     */
    private fun afterLoad() {
        afterTime++
        if (afterTime % 5 == 0) {
            presenter.fetchData()
        }
    }
}