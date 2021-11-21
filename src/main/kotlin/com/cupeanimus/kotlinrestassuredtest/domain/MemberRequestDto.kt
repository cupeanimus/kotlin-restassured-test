package com.cupeanimus.kotlinrestassuredtest.domain

data class MemberRequestDto(
    val name: String,
    val email: String,
    val password: String,
    val age: Int
)