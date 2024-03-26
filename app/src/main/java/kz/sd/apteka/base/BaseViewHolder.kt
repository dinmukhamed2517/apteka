package kz.sd.apteka.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.sd.apteka.adapters.Item
import kz.sd.apteka.firebase.Product

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BaseProductViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, Product>(binding)


abstract class BaseItemViewHolder<VB: ViewBinding>(override val binding:VB):
        BaseViewHolder<VB, Item>(binding)
