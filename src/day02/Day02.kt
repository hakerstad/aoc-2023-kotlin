package day02

import println
import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val maxRed = 12
        val maxGreen = 13
        val maxBlue = 14
        var sum = 0

        input.forEach { inputLine ->
            val (theGame, actualInput) = inputLine.split(":")
            val gameNo = theGame.split(" ")[1].toInt()
            val games = actualInput.split(";")
            var reds = 0
            var greens = 0
            var blues = 0
            games.forEach { game ->
                val cubes = game.split(",")
                cubes.forEach { cube ->
                    val (number, color) = cube.trimStart().split(" ")
                    val numberAsInt = number.toInt()
                    when (color.lowercase()) {
                        "red" -> if (numberAsInt > reds) reds = numberAsInt
                        "green" -> if (numberAsInt > greens) greens = numberAsInt
                        "blue" -> if (numberAsInt > blues) blues = numberAsInt
                    }
                }
            }
            if (reds <= maxRed && greens <= maxGreen && blues <= maxBlue) sum += gameNo
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        input.forEach { inputLine ->
            val (theGame, actualInput) = inputLine.split(":")
            val gameNo = theGame.split(" ")[1].toInt()
            val games = actualInput.split(";")
            var reds = 0
            var greens = 0
            var blues = 0
            games.forEach { game ->
                val cubes = game.split(",")
                cubes.forEach { cube ->
                    val (number, color) = cube.trimStart().split(" ")
                    val numberAsInt = number.toInt()
                    when (color.lowercase()) {
                        "red" -> if (numberAsInt > reds) reds = numberAsInt
                        "green" -> if (numberAsInt > greens) greens = numberAsInt
                        "blue" -> if (numberAsInt > blues) blues = numberAsInt
                    }
                }

            }
            sum += reds * greens * blues
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("day02/Day02_test")
//    check(part1(testInput) == 8)

    val testInput = readInput("day02/Day02_test")
    check(part2(testInput) == 2286)

    val input = readInput("day02/Day02")
//    part1(input).println()
    part2(input).println()
}