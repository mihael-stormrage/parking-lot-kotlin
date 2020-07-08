package parking

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    Parking.start()
}

object Parking {
    lateinit var parking: ParkingLot

    fun start() {
        with(scanner) { while (true) {
            println(when (val command = next()) {
                "exit" -> return
                "create" -> {
                    val spots = nextInt()
                    parking = ParkingLot(spots)
                    "Created a parking lot with $spots spots."
                }
                else ->
                    if (::parking.isInitialized) with(parking) { when (command) {
                        "park" -> park(next(), next())
                        "leave" -> leave(nextInt())
                        "status" -> toString()
                        "reg_by_color" -> regByColor(next())
                        "spot_by_color" -> spotByColor(next())
                        "spot_by_reg" -> spotByReg(next())
                        else -> "No such method!"
                    } }
                    else { nextLine(); "Sorry, a parking lot has not been created." }
            })
        } }
    }
}