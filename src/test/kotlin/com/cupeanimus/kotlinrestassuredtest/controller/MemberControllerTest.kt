package com.cupeanimus.kotlinrestassuredtest.controller

import com.cupeanimus.kotlinrestassuredtest.domain.MemberRequestDto
import com.cupeanimus.kotlinrestassuredtest.service.MemberService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
@AutoConfigureMockMvc
internal class MemberControllerTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var memberService: MemberService

    @Test
    fun save() {
        val uri = "/members"
        val memberDto = MemberRequestDto("name","email","password",20)
        val json = jacksonObjectMapper().writeValueAsString(memberDto)

        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isCreated)
    }

}