package com.cupeanimus.kotlinrestassuredtest.model

class Number(var number: Int, private var bonus: Int = 3) {

    fun add(addedNumber: Int) {
        number += addedNumber
        addBonus()
    }

    private fun addBonus() {
        if (bonus > 0) {
            number++
            bonus--
            return
        }
        refillBonus(10)
    }

    private fun refillBonus(refilledNumber: Int) {
        bonus = refilledNumber

    }
}