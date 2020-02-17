package ch02

import ch02.Color.*

fun getColorRgb(color: Color) =
    when (color) {
        RED -> "rgb(255, 0, 0)"
        BLUE -> "rgb(0, 0, 255)"
        BLACK -> "rgb(0, 0, 0)"
        else -> "rgb(255, 255, 255)"
    }