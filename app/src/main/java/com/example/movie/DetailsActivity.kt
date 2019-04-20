package com.example.movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = getIntent()

        val movie :MovieAthlete =intent.getSerializableExtra("movie") as MovieAthlete

        detailsmoviename?.text= movie.name
        detailsmoviebrief?.text=movie.brief
        if (movie.image != "") {
            Glide.with(this).load(movie.image).into(detailsimageView)
        }
        else {
            detailsimageView.visibility= View.GONE
            val params1 = detailsmoviename.getLayoutParams() as RelativeLayout.LayoutParams

            params1.topMargin =100
            detailsmoviename.setLayoutParams(params1)


            val params = detailsmoviebrief.getLayoutParams() as RelativeLayout.LayoutParams
            params.topMargin =500
            detailsmoviebrief.setLayoutParams(params)
        }
    }
}
