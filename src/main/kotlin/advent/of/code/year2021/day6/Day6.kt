package advent.of.code.year2021.day6

import advent.of.code.year2021.ContentReader

class Day6 {
    fun task1(fishesWithInitialSpawnDays: List<Int>, days: Int): Long {
        val initialFish = fishesWithInitialSpawnDays
            .groupingBy { it }
            .eachCount()
            .mapValues { it.value.toLong() }
        val ocean = Ocean(initialFish)
        spendTime(ocean, days)
        return ocean.fish.values.sum()
    }

    private fun spendTime(ocean: Ocean, days: Int) {
        repeat(times = days, action = { ocean.passDay() })
    }
}

fun main() {
    val initialFish = ContentReader.readFileAsText(6).split(",")
        .map { it.toInt() }

    val day6 = Day6()
    println(day6.task1(initialFish, 80))
    println(day6.task1(initialFish, 256))
}