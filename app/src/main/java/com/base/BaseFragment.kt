package com.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : Fragment() {
    protected var statusBarColor: String = "#FFFFFF"
    val binding: B by lazy { bindingFactory(layoutInflater) }
    abstract fun initView()

    abstract fun addEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        addEvent()

    }

    override fun onStart() {
        super.onStart()
        statusBar(statusBarColor)
    }


    protected fun statusBar(color: String){
        activity?.window?.statusBarColor = Color.parseColor(color)
    }

}