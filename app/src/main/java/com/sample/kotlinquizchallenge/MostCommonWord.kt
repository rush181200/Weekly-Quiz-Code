package com.sample.kotlinquizchallenge

/*
* Find the most frequently occurring word, ignoring common stop words.
*
* // Input
* findMostCommonWord("The sun shines and the sky is blue and clear")
*
* // Expected Output
* "The sun shines and the sky is blue and clear" → "and"
*
* */

private val STOP = setOf(
    "the","a","an","is","am","are","was","were","to","of","in","on","for","with","by","at","as","from"
)

fun findMostCommonWord(text: String): String {
    if (text.isBlank()) return ""

    val counts = mutableMapOf<String, Int>()


    val parts = text.split(Regex("\\s+"))

    for (raw in parts) {
        val word = raw.lowercase().filter { it.isLetter() }
        if (word.isEmpty() || word in STOP) continue
        counts[word] = counts.getOrPut(word) { 0 } + 1
    }

    return counts.maxByOrNull { it.value }?.key ?: ""
}

fun main() {
    val s = "The sun shines and the sky is blue and clear"
    println("\"$s\" → \"${findMostCommonWord(s)}\"") // → "and"
}