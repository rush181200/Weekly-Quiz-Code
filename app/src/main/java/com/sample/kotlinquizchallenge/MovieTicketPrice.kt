package com.sample.kotlinquizchallenge

/*
*
* Create a function that calculates movie ticket price based on age and showtime.
*
* // Input
* calculateTicketPrice(age = 25, isMatinee = false) // Adult, evening
* calculateTicketPrice(age = 70, isMatinee = true)  // Senior, matinee
* calculateTicketPrice(age = 8, isMatinee = false)  // Child, evening
*
* // Expected Output
* 25, false → 15
* 70, true → 8
* 8, false → 8
*
* */


fun main() {
    println("25, false → ${calculateTicketPrice(25, isMatinee = false)}")
    println("70, true → ${calculateTicketPrice(70, isMatinee = true)}")
    println("8, false → ${calculateTicketPrice(8,  isMatinee = false)}")
}

fun calculateTicketPrice(age: Int, isMatinee: Boolean): Int {
    require(age >= 0) { "Age cannot be negative" }
    return when{
        age<13 -> 8
        age in 13..64 -> if(isMatinee) 10 else 15
        else-> if(isMatinee) 8 else 10
    }
}