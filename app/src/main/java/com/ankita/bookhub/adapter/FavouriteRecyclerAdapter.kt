package com.ankita.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ankita.bookhub.R
import com.ankita.bookhub.activity.DescriptionActivity
import com.ankita.bookhub.database.BookEntity
import com.squareup.picasso.Picasso

class FavouriteRecyclerAdapter(val context: Context, val bookList: List<BookEntity>) :
    RecyclerView.Adapter<FavouriteRecyclerAdapter.FavouriteViewHolder>() {

    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtFavBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtFavBookAuthor: TextView = view.findViewById(R.id.txtFavBookAuthor)
        val txtFavBookPrice: TextView = view.findViewById(R.id.txtFavBookPrice)
        val txtFavBookRating: TextView = view.findViewById(R.id.txtFavBookRating)
        val imgFavBookImage: ImageView = view.findViewById(R.id.imgFavBookImage)
        val llFavContent: LinearLayout = view.findViewById(R.id.llFavContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favourite, parent, false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val book = bookList[position]
        holder.txtFavBookName.text = book.bookName
        holder.txtFavBookAuthor.text = book.bookAuthor
        holder.txtFavBookPrice.text = book.bookPrice
        holder.txtFavBookRating.text = book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.app_icon_round_foreground)
            .into(holder.imgFavBookImage)

        holder.llFavContent.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id", book.book_id.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}