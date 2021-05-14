package com.example.myunittesting.testing

class CuboidModel {
    private var width = 0.0
    private var length = 0.0
    private var height = 0.0

    fun getVolume() : Double = width * length * height

    fun getSurfaceArea() : Double {
        val w1 = width * length
        val wh = width * height
        val lh = length * height

        return 2 * (w1 + wh + lh)
    }

    fun getCircumference() : Double = 4 * (width + length + height)

    fun save(width: Double, length: Double, height: Double) {
        this.width = width
        this.length = length
        this.height = height
    }

}