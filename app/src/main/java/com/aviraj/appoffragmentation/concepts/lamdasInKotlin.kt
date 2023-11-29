package com.aviraj.appoffragmentation.concepts

object lamdasInKotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        println(multiply(5, 4))
    }
}


val multiply: (Int, Int) -> Int = { a, b -> a * b}