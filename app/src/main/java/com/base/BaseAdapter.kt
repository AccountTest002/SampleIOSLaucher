package com.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T> : RecyclerView.Adapter<ViewHolder> {
    //  var mCallback: OnActionCallback? = null
    var mList: List<T> = ArrayList()
    var context: Context? = null

    constructor()

    constructor(mList: List<T>) {
        this.mList = mList
    }

    constructor(context: Context?, mList: List<T>) {
        this.mList = mList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseInnerViewHolder {
        context = parent.context
        return viewHolder(parent, viewType)
    }

    protected abstract fun viewHolder(parent: ViewGroup?, viewType: Int): BaseInnerViewHolder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindView(holder as BaseAdapter<T>.BaseInnerViewHolder, position)
    }

    protected fun onBindView(viewHolder: BaseInnerViewHolder, position: Int) {
        viewHolder.bind(mList.get(position))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    abstract inner class BaseInnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: T)
    }

    abstract inner class BaseViewHolder<B : ViewBinding>(open var binding: B) :
        BaseInnerViewHolder(binding.root)
}