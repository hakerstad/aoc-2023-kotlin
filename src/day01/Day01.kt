enum class NumberStrings(val numberValue: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9)
}

fun main() {


    fun part1(input: List<String>): Int {
        val sum = input.map { inputLine ->
            val firstValue = inputLine.first { it.isDigit() }
            val secondValue = inputLine.last { it.isDigit() }
            val string = "$firstValue$secondValue"
            string.toInt()
        }.sum()
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        input.forEach { inputLine ->
            val pattern = "one|two|three|four|five|six|seven|eight|nine|\\d"
            val matchingList = mutableListOf<MatchResult>()
            for (i in 0..inputLine.length) {
                val match = Regex(pattern).find(inputLine, i)
                if (match != null) matchingList += match
            }
//            val matches = Regex(pattern).findAll(inputLine)
            val digits = mutableListOf<Int>()
            matchingList.forEach {
                val string = it.value
                if (string.isNotBlank() && string.toIntOrNull() != null) {
                     digits += string.toInt()
                } else if (string.isNotBlank()) {
                    val digit = string.toNumber()
                    if (digit != null) {
                        digits += digit
                    }
                }
            }
            val firstValue = digits.first()
            val lastValue = digits.last()
            val string = "$firstValue$lastValue"
            sum += string.toInt()
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test2")
//    check(part2(testInput) == 299)

    val input = readInput("day01/Day01_2")
//    part1(input).println()
    part2(input).println()
}

fun String.toNumber():Int? {
    return when (this.uppercase()) {
        NumberStrings.ONE.name -> 1
        NumberStrings.TWO.name -> 2
        NumberStrings.THREE.name -> 3
        NumberStrings.FOUR.name -> 4
        NumberStrings.FIVE.name -> 5
        NumberStrings.SIX.name -> 6
        NumberStrings.SEVEN.name -> 7
        NumberStrings.EIGHT.name -> 8
        NumberStrings.NINE.name -> 9
        else -> null
    }
}