package parking

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    Parking.start()
}

object Parking {
    lateinit var parking: ParkingLot

    fun start() {
        while (true) {
            println(when (val command = scanner.next()) {
                "exit" -> return
                "create" -> {
                    val spots = scanner.nextInt()
                    parking = ParkingLot(spots)
                    "Created a parking lot with $spots spots."
                }
                else -> if (::parking.isInitialized)
                    when (command) {
                        "park" -> parking.park(scanner.next(), scanner.next())
                        "leave" -> parking.leave(scanner.nextInt())
                        "status" -> parking.status()
                        else -> "No such method!"
                    } else { scanner.nextLine(); "Sorry, a parking lot has not been created." }
            })
        }
    }
}

class ParkingLot(val size: Int) {
    val lot = mutableMapOf<Int, Pair<String, String>>()

    fun park(regN: String, color: String): String {
        val freeSpot = (1..size).firstOrNull { it !in lot } ?: 1

        return if (lot.size == size) "Sorry, the parking lot is full." else {
            lot[freeSpot] = Pair(regN, color)
            "$color car parked in spot $freeSpot."
        }
    }

    fun leave(spot: Int) = if (lot.containsKey(spot)) {
        lot.remove(spot)
        "Spot $spot is free."
    } else "There is no car in spot $spot."

    fun status(): String {
        val state = mutableListOf<String>()
        lot.forEach { with(it) { state.add("$key ${value.first} ${value.second}") } }
        return if (state.any()) state.joinToString("\n") else "Parking lot is empty."
    }

    companion object {
        fun create(size: Int) = ParkingLot(size)
    }
}