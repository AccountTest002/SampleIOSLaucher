package com.example.launcherios17

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.base.BaseAdapter
import com.example.sampleioslaucher.databinding.AppItemBinding


class AppItemAdapter(context: Context, list: ArrayList<ItemApp>) :
    BaseAdapter<ItemApp>(context, list) {
    var onClickItem: ((ItemApp) -> Unit)? = null

    override fun viewHolder(parent: ViewGroup?, viewType: Int): BaseInnerViewHolder {
        return ViewHolder(AppItemBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    private inner class ViewHolder(binding: AppItemBinding) :
        BaseViewHolder<AppItemBinding>(binding) {
        override fun bind(item: ItemApp) {
            if (item.packageName != "") {
                binding.ivIcon.visibility = View.VISIBLE
                binding.tvTitle.visibility = View.VISIBLE
                binding.ivIcon.setImageDrawable(item.drawable)
                binding.tvTitle.text = item.name
            }

            itemView.setOnClickListener {
                context?.let {ct  ->
                    val launchIntent: Intent? =
                        ct.packageManager.getLaunchIntentForPackage(item.packageName)


                    launchIntent?.let {
                      ct.startActivity(it)
                    }
                }
            }
        }

    }
}