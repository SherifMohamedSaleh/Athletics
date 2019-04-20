package com.example.movie


import com.google.gson.annotations.SerializedName

data class MovieList(@SerializedName("athletes") var athletes: List<MovieAthlete>) {
}