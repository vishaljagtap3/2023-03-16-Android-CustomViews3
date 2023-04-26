package com.bitcodetech.customview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.customview3.adapters.ProductsAdapter
import com.bitcodetech.customview3.models.Product
import com.bitcodetech.customview3.views.ProductView

class MainActivity : AppCompatActivity() {

    /*private lateinit var productView1: ProductView
    private lateinit var productView2: ProductView*/

    private lateinit var recyclerProducts : RecyclerView
    private val products = ArrayList<Product>()

    private lateinit var productsAdapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initViews()
    }

    private fun initData() {
        products.add(Product(101, "Demo Product1", 1234, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(102, "Demo Product2", 23442, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(103, "Demo Product3", 3422, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(104, "Demo Product4", 435, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(105, "Demo Product5", 564353, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(106, "Demo Product6", 56746, 4.5f, R.mipmap.ic_launcher))
        products.add(Product(107, "Demo Product7", 2133, 4.5f, R.mipmap.ic_launcher))

    }

    private fun initViews() {
        recyclerProducts = findViewById(R.id.recyclerProducts)
        recyclerProducts.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        productsAdapter = ProductsAdapter(products)
        recyclerProducts.adapter = productsAdapter
        productsAdapter.onProductClickListener = MyOnProductClickListener()
    }

    /*private fun initViews() {
        val myOnProductClickListener = MyOnProductClickListener()
        productView1 = findViewById(R.id.productView1)
        productView1.product = Product(101, "Asus Laptop", 12345, 4.6f, R.mipmap.ic_launcher)
        productView1.onProductClickListener = myOnProductClickListener

        productView2 = findViewById(R.id.productView2)
        productView2.product = Product(102, "Dell Laptop", 67890, 4.1f, R.mipmap.ic_launcher)
        productView2.onProductClickListener = myOnProductClickListener
    }

    private inner class MyOnProductClickListener : ProductView.OnProductClickListener {
        override fun onImageClick(productView: ProductView, imageView: ImageView, imageId: Int) {
            //if(productView == productView1) { }
            mt("MA: image clicked ${imageView.id}")
        }

        override fun onTitleClick(productView: ProductView, txtTitle: TextView, title: String) {
            mt("MA: title clicked ${txtTitle.id} $title")
        }

        override fun onPriceClick(productView: ProductView, txtPrice: TextView, price: Int) {
            mt("MA: price clicked ${txtPrice.id} $price")
        }

        override fun onRatingChanged(
            productView: ProductView,
            ratingBar: RatingBar,
            newRating: Float
        ) {
            mt("MA: rating clicked ${ratingBar.id} $newRating")
        }


    }*/

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private inner class MyOnProductClickListener : ProductsAdapter.OnProductClickListener {
        override fun onImageClick(
            position: Int,
            productView: ProductView,
            imageView: ImageView,
            imageId: Int
        ) {
            mt("image: $position")
        }

        override fun onTitleClick(
            position: Int,
            productView: ProductView,
            txtTitle: TextView,
            title: String
        ) {
            mt("title: $position")
        }

        override fun onPriceClick(
            position: Int,
            productView: ProductView,
            txtPrice: TextView,
            price: Int
        ) {
            mt("price: $position")
        }

        override fun onRatingChanged(
            position: Int,
            productView: ProductView,
            ratingBar: RatingBar,
            newRating: Float
        ) {
            mt("rating: $position")
        }

    }
}