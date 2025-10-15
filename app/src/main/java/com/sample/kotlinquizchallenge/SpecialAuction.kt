package com.sample.kotlinquizchallenge

/*
*
* Implement an auction bidding system where new bids must be higher than current bid.
*
* // Input
* placeBid(50)  // First bid
* placeBid(30)  // Too low
* placeBid(75)  // Valid higher bid
*
* // Expected Output
* 50 → 50 (accepted)
* 30 → null (rejected)
* 75 → 75 (accepted)
* */

object Auction {
    private var currentBid: Int? = null

    fun placeBid(amount: Int): Int? {
        if (amount <= 0) return null                       // reject non-positive bids
        return if (currentBid == null || amount > currentBid!!) {
            currentBid = amount
            amount
        } else {
            null
        }
    }

    fun getCurrentBid(): Int? = currentBid
}

// Demo
fun main() {
    println("50 → ${Auction.placeBid(50)}")  // accepted
    println("30 → ${Auction.placeBid(30)}")  // rejected (too low)
    println("75 → ${Auction.placeBid(75)}")  // accepted (higher)
}