package com.cupeanimus.kotlinrestassuredtest.controller

import com.cupeanimus.kotlinrestassuredtest.BaseTestTest
import io.restassured.RestAssured.get
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.apache.http.HttpStatus
import org.assertj.core.api.Assertions
import org.hamcrest.Matchers.equalTo

class TestCallTest : BaseTestTest() {

    @DisplayName("Get요청을 보내 OK를 받는다")
    @Test
    fun `get and return`() {
        val message:String =Given {
            spec(requestSpecification)
        } When {
            get("/test")
        } Then {
            statusCode(200)
        } Extract  {
            response().asString()
        }
        Assertions.assertThat(message).isEqualTo("ok")

    }



}