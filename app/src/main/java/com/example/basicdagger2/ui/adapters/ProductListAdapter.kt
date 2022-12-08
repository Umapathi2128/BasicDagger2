package com.example.basicdagger2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.basicdagger2.R
import com.example.basicdagger2.databinding.ListItemBinding
import com.example.basicdagger2.di.ActivitiesModules
import com.example.basicdagger2.model.ProductDataModel
import com.example.basicdagger2.model.ProductItem
import com.example.basicdagger2.utils.Utils
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class ProductListAdapter(var listener : SetItemClickListener) : RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    var list = arrayListOf<ProductItem>()
    lateinit var binding : ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.list_item,parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            listener.clickListener(list[position])
        }
    }

    override fun getItemCount(): Int = list.size


    fun addProducts(pList : ProductDataModel){
        list.clear()
        list = pList
    }

    class MyViewHolder(var binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun onBind(productDataModel: ProductItem){
            productDataModel.apply {
                binding.txtTitle.text = title
                binding.txtCategory.text = category
                binding.txtDescription.text = description
                binding.rating.rating = rating.rate.toFloat()
            }

            Glide.with(binding.imgProduct.context).load(productDataModel.image).
                    placeholder(Utils.getImagePlaceHolderLoading(binding.imgProduct.context))
                .error(R.drawable.ic_launcher_background).into(binding.imgProduct)
        }
    }

    interface SetItemClickListener{
        fun clickListener(productItem: ProductItem)
    }

}