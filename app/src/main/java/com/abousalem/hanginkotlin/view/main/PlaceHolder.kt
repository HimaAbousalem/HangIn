package com.abousalem.hanginkotlin.view.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abousalem.hanginkotlin.R
import com.abousalem.hanginkotlin.entities.response.Place
import com.squareup.picasso.Picasso

class PlaceHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var imgView: ImageView? = null
    private var tvName: TextView? = null
    private var tvAddress: TextView? = null

    init {
        imgView = view.findViewById(R.id.place_imageView)
        tvName = view.findViewById(R.id.place_name_textView)
        tvAddress = view.findViewById(R.id.place_address_textView)
    }

    fun bindView(place: Place) {
        Picasso.get()
            .load(place.image)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_error)
            .into(imgView)

        tvName!!.text = place.name
        tvAddress!!.text = place.address
    }

}