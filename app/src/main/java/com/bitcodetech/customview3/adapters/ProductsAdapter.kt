package com.bitcodetech.customview3.adapters


import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.customview3.models.Product
import com.bitcodetech.customview3.views.ProductView

class ProductsAdapter(
    val products: ArrayList<Product>
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {


    interface OnProductClickListener {
        fun onImageClick(position : Int, productView: ProductView, imageView : ImageView, imageId : Int)
        fun onTitleClick(position : Int, productView: ProductView, txtTitle : TextView, title : String)
        fun onPriceClick(position : Int, productView: ProductView, txtPrice : TextView, price : Int)
        fun onRatingChanged(position : Int, productView: ProductView, ratingBar : RatingBar, newRating : Float)
    }

    var onProductClickListener : OnProductClickListener? = null


    inner class ProductViewHolder(
        val productView: ProductView
    ) : RecyclerView.ViewHolder(productView) {

        init {

            productView.onProductClickListener =
                object : ProductView.OnProductClickListener {
                    override fun onImageClick(
                        productView: ProductView,
                        imageView: ImageView,
                        imageId: Int
                    ) {
                        onProductClickListener?.onImageClick(
                            adapterPosition,
                            productView,
                            imageView,
                            imageId
                        )
                    }

                    override fun onTitleClick(
                        productView: ProductView,
                        txtTitle: TextView,
                        title: String
                    ) {
                        onProductClickListener?.onTitleClick(
                            adapterPosition,
                            productView,
                            txtTitle,
                            title
                        )
                    }

                    override fun onPriceClick(
                        productView: ProductView,
                        txtPrice: TextView,
                        price: Int
                    ) {
                        onProductClickListener?.onPriceClick(
                            adapterPosition,
                            productView,
                            txtPrice,
                            price
                        )
                    }

                    override fun onRatingChanged(
                        productView: ProductView,
                        ratingBar: RatingBar,
                        newRating: Float
                    ) {
                        onProductClickListener?.onRatingChanged(
                            adapterPosition,
                            productView,
                            ratingBar,
                            newRating
                        )
                    }

                }

        }

    }


    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductView(parent.context)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productView.product = products[position]
    }
}