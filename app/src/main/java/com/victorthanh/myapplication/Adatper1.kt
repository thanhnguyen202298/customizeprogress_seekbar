package com.victorthanh.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Adatper1(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val myList = ArrayList<MyData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layuout_item,parent,false)
        return MyHolder(view)
    }

    var position = -1

    override fun getItemCount(): Int {
        return myList.size
    }

    fun updateItem(position: Int, ischec: Boolean) {
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemv = holder.itemView.findViewById<TextView>(R.id.descipt)

        itemv.setText(myList.get(position).text)
        if (position== this.position)
            itemv.setBackgroundColor(context.resources.getColor(R.color.colorAccent))
        else
            itemv.setBackgroundColor(context.resources.getColor(R.color.colorWhite))

    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class Onscroller(val data:MutableLiveData<scrolldata>) : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val layoutMana = recyclerView.layoutManager as LinearLayoutManager
            val first = layoutMana.findFirstVisibleItemPosition()
            val adpter = recyclerView.adapter as Adatper1

            if (recyclerView.contentDescription == "updateState") {
                data.value = scrolldata(dy,"list2")
            }else{
                data.value = scrolldata(dy,"list1")
            }


        }
    }

    class OnsrollNew():RecyclerView.SmoothScroller(){

        var rycler:RecyclerView?=null
            set(value) {
                field = value
            }

        override fun onSeekTargetStep(dx: Int, dy: Int, state: RecyclerView.State, action: Action) {

        }

        override fun onStop() {
            TODO("Not yet implemented")
        }

        override fun onTargetFound(targetView: View, state: RecyclerView.State, action: Action) {
            TODO("Not yet implemented")
        }

        override fun onStart() {
            TODO("Not yet implemented")
        }
    }

    var rycler:RecyclerView?=null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        rycler = recyclerView
        super.onAttachedToRecyclerView(recyclerView)

    }
}
