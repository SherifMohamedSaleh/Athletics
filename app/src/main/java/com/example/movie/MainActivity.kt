package com.example.movie

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClientInstance.retrofitInstance?.create(ResponseM::class.java)
        val call = service?.getAllMovies()

        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
        call?.enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                val body = response?.body()
                val athlete = body?.athletes!!
                val adapter = MyAdapter(this@MainActivity, athlete , { movie : MovieAthlete -> movieItemClicked(movie) })
                recyclerView.adapter = adapter
            }
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                // error handel it TODO
            }
        })
    }
    private fun movieItemClicked(movie: MovieAthlete) {

        val intent = Intent(this@MainActivity, DetailsActivity::class.java)


        intent.putExtra("movie", movie)
        startActivity(intent)

    }
}
