package com.sample.kotlinquizchallenge

/*
*
* Write a function that removes all vowels from a string, case-insensitive.
*
* // Input
* removeVowels("Hello World")
* removeVowels("Kotlin Programming")
*
* // Expected Output
* "Hello World" → "Hll Wrld"
* "Kotlin Programming" → "Ktln Prgrmmng"
* */

fun main() {
   val str1 = removeVowels("Hello World")
   val str2 = removeVowels("Kotlin Programming")
    println(str1)
    println(str2)
}

fun removeVowels(str: String): String{
    val vowels = setOf('a','e','i','o','u')
    val sb = StringBuilder(str.length)
    for (ch in str) {
        if (ch.lowercaseChar() !in vowels) sb.append(ch)
    }
    return sb.toString()
}