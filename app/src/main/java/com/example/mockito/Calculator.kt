package com.example.mockito

class Calculator() {
    fun add(d1: Double, d2: Double): Double {
        return icalc.add(d1, d2)
    }

    fun subtract(d1: Double, d2: Double): Double {
        return icalc.subtract(d1, d2)
    }

    fun multiply(d1: Double, d2: Double): Double {
        return icalc.multiply(d1, d2)
    }

    fun divide(d1: Double, d2: Double): Double {
        return icalc.divide(d1, d2)
    }

    fun double15(): Double {
        return 15.0
    }
}