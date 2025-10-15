package com.sample.kotlinquizchallenge

/*
*
* Create a Song class with properties and computed properties.
*
* // Input
* val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)
*
* // Expected Output
* song.formattedDuration → "05:54"
* song.isPopular() → true
*
* */

class Song(
    val title: String,
    val artist: String,
    val playCount: Int,
    val durationSeconds: Int
) {
     val formattedDuration: String
        get() {
            val minutes = durationSeconds / 60
            val seconds = durationSeconds % 60
            return "%02d:%02d".format(minutes, seconds)
        }

    fun isPopular(): Boolean = playCount >= 1000000
}

fun main() {
    val song = Song("Bohemian Rhapsody", "Queen", 2500000, 354)

    println("Duration: ${song.formattedDuration}")
    println("Popular: ${song.isPopular()}")
}