package kz.sd.apteka.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sd.apteka.base.BaseProductViewHolder
import kz.sd.apteka.base.BaseViewHolder
import kz.sd.apteka.databinding.ItemProductBinding
import kz.sd.apteka.firebase.Product

class ProductAdapter: ListAdapter<Product, BaseProductViewHolder<*>>(ProductDiffUtils()) {

    var itemClick:((Product) ->Unit)? = null

    class ProductDiffUtils:DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseProductViewHolder<*> {
        return ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseProductViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ProductViewHolder(binding:ItemProductBinding):BaseProductViewHolder<ItemProductBinding>(binding){
        override fun bindView(item: Product) {
            with(binding){
                item.img?.let { imageView.setImageResource(it) }
                title.text = item.title
                price.text = item.price.toString()+" KZT"

                var bonusAmount = item.price?.times(0.05)
                bonus.text = "+ "+bonusAmount.toString()+ " бонусов"
            }
            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }

    }
}
