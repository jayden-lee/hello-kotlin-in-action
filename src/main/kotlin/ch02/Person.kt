package ch02

class Person(val name: String, var isMarried: Boolean)

fun main(args: Array<String>) {
    val person = Person("Jayden", false)

     // person.name = "gglee" 수정 불가능
     // person.isMarried = true 수정 가능
}