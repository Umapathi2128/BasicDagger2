package com.example.basicdagger2.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basicdagger2.MyApplication
import com.example.basicdagger2.R
import com.example.basicdagger2.databinding.ActivityMainBinding
import com.example.basicdagger2.model.ProductItem
import com.example.basicdagger2.ui.adapters.ProductListAdapter
import com.example.basicdagger2.ui.detail.DetailActivity
import com.example.basicdagger2.utils.NetworkHelper
import com.example.basicdagger2.utils.Status
import com.example.basicdagger2.utils.isShow
import javax.inject.Inject

class MainActivity : AppCompatActivity(),ProductListAdapter.SetItemClickListener {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var mainVmFactory: MainVmFactory

    @Inject
    lateinit var networkHelper: NetworkHelper

    lateinit var productListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).appComponant.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this, mainVmFactory)[MainViewModel::class.java]

        binding.mainBinding = viewModel

        productListAdapter = ProductListAdapter(this)

        initRecyclerView()
        getProductObservables()

    }

    private fun getProductObservables() {

        viewModel.products.observe(this, {

            when (it.status) {
                Status.LOADING -> {
                    binding.apply {
                        recyclerView.isShow(false)
                        txtError.isShow(false)
                        progressbar.isShow(true)
                    }
                }
                Status.ERROR -> {
                    binding.apply {
                        recyclerView.isShow(false)
                        txtError.isShow(true)
                        progressbar.isShow(false)
                        txtError.text = it.message
                    }
                }
                Status.SUCCESS -> {
                    binding.apply {
                        recyclerView.isShow(true)
                        txtError.isShow(false)
                        progressbar.isShow(false)
                    }
                    val data = it.data
                    if (data?.size!! > 1) productListAdapter.addProducts(data)
                }
            }

        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productListAdapter
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun clickListener(productItem: ProductItem) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra("title",productItem.title)
        intent.putExtra("price",productItem.price)
        intent.putExtra("description",productItem.description)
        intent.putExtra("image",productItem.image)
        intent.putExtra("rating",productItem.rating.rate.toString())
        startActivity(intent)
    }

}