package parking

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val parking = BooleanArray(20)

    do {
        val command = scanner.next()

        when (command) {
            "park" -> {
                scanner.next()

                val firstFree = parking.indexOfFirst { !it }
                val freeSpot = if (firstFree == -1) 0 else firstFree

                println(if (parking.all { it }) "Sorry, the parking lot is full." else {
                    parking[freeSpot] = true
                    "${scanner.next()} car parked in spot ${freeSpot + 1}."
                })
            }
            "leave" -> {
                val spot = scanner.nextInt()
                println(if (parking[spot - 1]) {
                    parking[spot - 1] = false
                    "Spot $spot is free."
                } else "There is no car in spot $spot.")
            }
        }
    } while (command != "exit")
}