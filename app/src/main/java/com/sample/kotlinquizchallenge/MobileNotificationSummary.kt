package com.sample.kotlinquizchallenge

/*
*
* Write a function that takes the number of notifications a user has received and returns a summary string.
*
* Example
* -> 0 -> No Notifications
* -> 3-99 -> You have 3 Notifications
* -> 100+ -> You have Notifications 99+
* */

fun main() {
    var number: Int
    while (true) {
        print("Enter a number of Notifications: ")
        val raw = readLine()?.trim().orEmpty()
        val inputNumber = raw.toIntOrNull()
        if (inputNumber == null) {
            println("Please enter a valid integer (e.g., 42 or -7).")
            continue
        }
        number = kotlin.math.abs(inputNumber)
        break
    }

    numberOfNotification(number)

}

fun numberOfNotification(number: Int){
    if(number<99 && number>0){
        print("You have $number Notifications")
    }else if(number>100){
        print("You have Notifications 99+")
    }else{
        print("No Notifications")
    }
}