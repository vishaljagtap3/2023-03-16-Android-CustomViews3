package com.bitcodetech.customview3.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import com.bitcodetech.customview3.R
import com.bitcodetech.customview3.models.Product

class ProductView(
    context: Context,
    attributeSet: AttributeSet?
) : LinearLayout(context, attributeSet) {

    val imgProduct: ImageView
    val txtTitle: TextView
    val txtPrice: TextView
    val ratingProduct: RatingBar

    var product : Product? = null
    set(value) {
        field = value
        bindProductToViews()
    }

    constructor(context: Context) : this(context, null)

    init {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.product_view, null)

        this.addView(view)

        imgProduct = view.findViewById(R.id.imgProduct)
        txtTitle = view.findViewById(R.id.txtTitle)
        txtPrice = view.findViewById(R.id.txtPrice)
        ratingProduct = view.findViewById(R.id.ratingProduct)

        setupListeners()
    }

    interface OnProductClickListener {
        fun onImageClick(productView: ProductView, imageView : ImageView, imageId : Int)
        fun onTitleClick(productView: ProductView, txtTitle : TextView, title : String)
        fun onPriceClick(productView: ProductView, txtPrice : TextView, price : Int)
        fun onRatingChanged(productView: ProductView, ratingBar : RatingBar, newRating : Float)
    }

    var onProductClickListener : OnProductClickListener? = null

    private fun setupListeners() {
        imgProduct.setOnClickListener {
            //mt("image of ${product!!.id} clicked")
            onProductClickListener?.onImageClick(
                this,
                imgProduct,
                product!!.imageId
            )
        }

        txtTitle.setOnClickListener {
            //mt("title of ${product!!.id} clicked")
            onProductClickListener?.onTitleClick(
                this,
                txtTitle,
                product!!.title
            )
        }

        txtPrice.setOnClickListener {
            //mt("price of ${product!!.id} clicked")
            onProductClickListener?.onPriceClick(
                this,
                txtPrice,
                product!!.price
            )
        }

        ratingProduct.setOnRatingBarChangeListener(
            object : RatingBar.OnRatingBarChangeListener {
                override fun onRatingChanged(ratingBar: RatingBar?, rating : Float, p2: Boolean) {
                    //mt("raging changed to $rating")
                    //product!!.rating = rating
                    onProductClickListener?.onRatingChanged(
                        this@ProductView,
                        ratingProduct,
                        rating
                    )
                }
            }
        )
    }

    private fun mt(text : String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }


    private fun bindProductToViews() {
        if(product != null) {
            imgProduct.setImageResource(product!!.imageId)
            txtTitle.text = product!!.title
            txtPrice.text = "INR. ${product!!.price}"
            ratingProduct.rating = product!!.rating
        }
    }

}