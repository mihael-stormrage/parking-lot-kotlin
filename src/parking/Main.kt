package parking

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    when (scanner.next()) {
        "park" -> {
            scanner.next()
            println("${scanner.next()} car parked in spot 2.")
        }
        "leave" -> {
            val spot = scanner.nextInt()
            println(if (spot == 1) "Spot 1 is free." else "There is no car in spot $spot.")
        }
    }
}