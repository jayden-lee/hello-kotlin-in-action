package ch02

import java.util.Random

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return this.height == this.width
        }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(100, 100)
    println("정사각형: ${rectangle.isSquare}")
}