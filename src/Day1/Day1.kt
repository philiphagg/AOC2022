package Day1

import java.io.File

var calorieCounter = 0
var highestNumber = 0
fun main() {
    val filepath: String = "src/Day1/input.txt"
    readFileLineByLineUsingForEachLine(filepath)
    println("Highest number: $highestNumber")
}

fun readFileLineByLineUsingForEachLine(filepath: String) {
    File(filepath).forEachLine {
        if (it == "") {
            if (calorieCounter > highestNumber) {
                highestNumber = calorieCounter
            }
            calorieCounter = 0
        } else {
            calorieCounter += it.toInt()
        }
    }
}