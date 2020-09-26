package com.victorthanh.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mhandler = Handler(Looper.getMainLooper())
    var pro = 0
    var scrokk = MutableLiveData<scrolldata>()
    fun progressExcute() {
        mhandler.postDelayed({
            pro += 10
            tabprogress.setProgress(pro)
            if (pro < 100)
                progressExcute()
        }, 1000L)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressExcute()

        val adatper1 = Adatper1(this)
        val adatper2 = Adatper1(this)
        adatper1.myList.add(MyData("fuydfhdkfdfd"))
        adatper1.myList.add(MyData("nbhjhjhj"))
        adatper1.myList.add(MyData("loplioli"))
        adatper1.myList.add(MyData("tytrytydgsfst"))
        adatper1.myList.add(MyData("vbgddfsdffg"))
        adatper1.myList.add(MyData("sdsafhghg"))
        adatper1.myList.add(MyData("poiphghgio"))
        adatper1.myList.add(MyData("mmnbmhghg"))
        adatper1.myList.add(MyData("nbnbtytyn"))
        adatper1.myList.add(MyData("hghfghghghghg"))
        adatper1.myList.add(MyData("tytrytydgsfst"))
        adatper1.myList.add(MyData("vbgddfsdffg"))
        adatper1.myList.add(MyData("sdsafhghg"))
        adatper1.myList.add(MyData("poiphghgio"))
        adatper1.myList.add(MyData("mmnbmhghg"))
        adatper1.myList.add(MyData("nbnbtytyn"))
        adatper1.myList.add(MyData("hghfghghghghg"))
        adatper1.myList.add(MyData("tytrytydgsfst"))
        adatper1.myList.add(MyData("vbgddfsdffg"))
        adatper1.myList.add(MyData("sdsafhghg"))
        adatper1.myList.add(MyData("poiphghgio"))
        adatper1.myList.add(MyData("mmnbmhghg"))
        adatper1.myList.add(MyData("nbnbtytyn"))
        adatper1.myList.add(MyData("hghfghghghghg"))

        adatper2.myList.add(MyData("fuydfhdkfdfd"))
        adatper2.myList.add(MyData("nbhjhjhj"))
        adatper2.myList.add(MyData("loplioli"))
        adatper2.myList.add(MyData("tytrytydgsfst"))
        adatper2.myList.add(MyData("vbgddfsdffg"))
        adatper2.myList.add(MyData("sdsafhghg"))
        adatper2.myList.add(MyData("poiphghgio"))
        adatper2.myList.add(MyData("mmnbmhghg"))
        adatper2.myList.add(MyData("nbnbtytyn"))
        adatper2.myList.add(MyData("hghfghghghghg"))
        adatper2.myList.add(MyData("tytrytydgsfst"))
        adatper2.myList.add(MyData("vbgddfsdffg"))
        adatper2.myList.add(MyData("sdsafhghg"))
        adatper2.myList.add(MyData("poiphghgio"))
        adatper2.myList.add(MyData("mmnbmhghg"))
        adatper2.myList.add(MyData("nbnbtytyn"))
        adatper2.myList.add(MyData("hghfghghghghg"))
        adatper2.myList.add(MyData("tytrytydgsfst"))
        adatper2.myList.add(MyData("vbgddfsdffg"))
        adatper2.myList.add(MyData("sdsafhghg"))
        adatper2.myList.add(MyData("poiphghgio"))
        adatper2.myList.add(MyData("mmnbmhghg"))
        adatper2.myList.add(MyData("nbnbtytyn"))
        adatper2.myList.add(MyData("hghfghghghghg"))

        val lis1 = findViewById<RecyclerView>(R.id.list01)
        val lis2 = findViewById<RecyclerView>(R.id.list02)

        val laymana = LinearLayoutManager(this)
        val laymana2 = LinearLayoutManager(this)
        laymana.orientation = LinearLayoutManager.VERTICAL
        lis1.layoutManager = laymana
        lis2.layoutManager = laymana2

        lis1.adapter = adatper1
        lis2.adapter = adatper2

        val msroll = Adatper1.Onscroller(scrokk)
        lis1.setOnScrollListener(msroll)
        lis2.setOnScrollListener(msroll)
        scrokk.observe(this, Observer {
            if (it.from == "list1") {
                lis2.smoothScrollBy(0, it.dy)
            } else {

                lis1.smoothScrollBy(0, it.dy)
            }
        })
    }
}
