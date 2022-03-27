package com.cupeanimus.kotlinrestassuredtest.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.test.util.ReflectionTestUtils

internal class NumberTest {

    @Test
    fun `getBonusFieldTest`() {
        // given
        val number = Number(10, 5)

        // when
        number.add(1)

        // then
        val bonus = ReflectionTestUtils.getField(number, "bonus") as Int
        assertThat(bonus).isEqualTo(4)
    }

    @Test
    fun `privateAddBonusTest`() {
        // given
        val number = Number(10, 1)

        // when
        ReflectionTestUtils.invokeMethod<Number>(number, "addBonus")

        // then
        val bonus = ReflectionTestUtils.getField(number, "bonus") as Int
        assertThat(bonus).isEqualTo(0)
    }


    @Test
    fun `privateRefillBonusTest`() {
        // given
        val number = Number(10, 1)

        // when
        ReflectionTestUtils.invokeMethod<Number>(number, "refillBonus",10)

        // then
        val bonus = ReflectionTestUtils.getField(number, "bonus") as Int
        assertThat(bonus).isEqualTo(10)
    }

}