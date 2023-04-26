package com.bitcodetech.customview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.bitcodetech.customview3.models.Product
import com.bitcodetech.customview3.views.ProductView

class MainActivity : AppCompatActivity() {

    private lateinit var productView1: ProductView
    private lateinit var productView2: ProductView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

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


    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}