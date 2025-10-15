package com.sample.kotlinquizchallenge

/*
*
* Write a higher-order function that can convert between Celsius and Fahrenheit.
*
* convertTemperature(25.0, celsiusToFahrenheit) //needs to be a higher order function
* convertTemperature(98.6, fahrenheitToCelsius)
*
* // Expected Output
* 25.0 → 77.0
* 98.6 → 37.0
* */

fun convertTemperature(value: Double, converter: (Double) -> Double): Double {
    return converter(value)
}

val celsiusToFahrenheit: (Double) -> Double = { c -> c * 9 / 5 + 32 }
val fahrenheitToCelsius: (Double) -> Double = { f -> (f - 32) * 5 / 9 }


fun main() {
    val cToF = convertTemperature(25.0, celsiusToFahrenheit)
    val fToC = convertTemperature(98.6, fahrenheitToCelsius)

    println("25.0 → $cToF") 
    println("98.6 → $fToC")
}