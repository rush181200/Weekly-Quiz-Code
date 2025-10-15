package com.sample.kotlinquizchallenge

/*
* Find the longest sequence of consecutive zeros in binary representation surrounded by ones.
*
* // Input
* findBinaryGap(9)   // Binary: 1001
* findBinaryGap(529) // Binary: 1000010001
* findBinaryGap(32)  // Binary: 100000
*
* // Expected Output
* 9 → 2
* 529 → 4
* 32 → 0 (no gap surrounded by ones)
* */

fun main() {
    print("Enter a number : ")
    val binaryNumber = readLine()?.toIntOrNull() ?: 0

    val binaryString = binaryNumber.toString(2)
    println("Binary representation of $binaryNumber is: $binaryString")
    val maxGap = findBinaryGap(binaryString)
    println("The longest sequence of consecutive zeros in binary representation is: $maxGap")
}

fun findBinaryGap(binaryString: String): Int {
    var maxGap = 0
    var currentGap = 0

    for (char in binaryString) {
        if (char == '0') {
            currentGap++
        } else {
            maxGap = maxOf(maxGap, currentGap)
            currentGap = 0
        }
    }
    return maxGap
}