package kz.sd.apteka.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sd.apteka.base.BaseItemViewHolder
import kz.sd.apteka.databinding.ItemBinding

class ItemAdapter:ListAdapter<Item, BaseItemViewHolder<*>>(ItemDiffUtils()) {

    var itemClick: ((Item) ->Unit)? = null
    class ItemDiffUtils:DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<*> {
        return ItemViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        )
    }

    override fun onBindViewHolder(holder: BaseItemViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
    inner class ItemViewHolder(binding:ItemBinding):BaseItemViewHolder<ItemBinding>(binding){
        override fun bindView(item: Item) {
            binding.title.text = item.title
            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }

    }
}