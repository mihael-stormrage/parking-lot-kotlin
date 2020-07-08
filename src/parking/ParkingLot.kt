package parking

class ParkingLot(val size: Int) {
    private val lot = mutableMapOf<Int, Car>()

    fun park(regN: String, color: String): String {
        val freeSpot = (1..size).firstOrNull { it !in lot } ?: 1

        return if (lot.size == size) "Sorry, the parking lot is full." else {
            lot[freeSpot] = Car(regN, color)
            "$color car parked in spot $freeSpot."
        }
    }

    fun leave(spot: Int) = if (lot.containsKey(spot)) {
        lot.remove(spot)
        "Spot $spot is free."
    } else "There is no car in spot $spot."

    fun regByColor(color: String) = lot.values.filter {
        it.color.equals(color, true) }.joinToString(", ") { it.regN }
            .ifEmpty { "No cars with color $color were found." }

    fun spotByColor(color: String) = lot.filter {
        it.value.color.equals(color, true) }.map { it.key }.joinToString(", ")
            .ifEmpty { "No cars with color $color were found." }

    fun spotByReg(regN: String) = lot.filter { it.value.regN == regN }.map { it.key }
            .singleOrNull() ?: "No cars with registration number $regN were found."

    override fun toString(): String {
        val state = mutableListOf<String>()
        lot.forEach { with(it) { state.add("$key $value") } }
        return state.joinToString("\n").ifEmpty { "Parking lot is empty." }
    }
}

data class Car(val regN: String, val color: String) {
    override fun toString() = "$regN $color"
}