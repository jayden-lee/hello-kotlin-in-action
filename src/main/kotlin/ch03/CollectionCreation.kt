package ch03

fun main(args: Array<String>) {
    var set = hashSetOf(1, 5, 10)
    var list = arrayListOf(1,2,3)
    var map = hashMapOf(1 to "one", 3 to "three", 5 to "five")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}
