package ch01

data class Person(val name: String, val age: Int ?= null)

fun main(args: Array<String>) {
    val persons = listOf(
        Person("jayden", 29),
        Person("ella", 28)
    )

    val oldest = persons.maxBy { it.age?: 0 }

    println("나이가 가장 많은 사람: $oldest")
}