package com.example.basicdagger2.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.bumptech.glide.Glide
import com.example.basicdagger2.MyApplication
import com.example.basicdagger2.R
import com.example.basicdagger2.databinding.ActivityDetailBinding
import com.example.basicdagger2.model.ProductItem
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var detailVmFactory: DetailVmFactory

    lateinit var binding : ActivityDetailBinding
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as MyApplication).appComponant.inject(this)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
        viewModel = ViewModelProvider(this,detailVmFactory)[DetailViewModel::class.java]
        binding.detailBinding = viewModel

        getBundleDetails()

    }

    private fun getBundleDetails() {

        if (intent.extras != null) {
            viewModel.apply {
                eTitle.value = intent.getStringExtra("title")
                ePrice.value = intent.getStringExtra("price")
                eDescription.value = intent.getStringExtra("description")
                eRatting.value = intent.getStringExtra("rating")?.toFloat()
            }
            val url = intent.getStringExtra("image")

            Glide.with(this).load(url).into(binding.detailImage)
        }
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show()


    }
}