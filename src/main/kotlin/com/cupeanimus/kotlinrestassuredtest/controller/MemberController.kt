package com.cupeanimus.kotlinrestassuredtest.controller

import com.cupeanimus.kotlinrestassuredtest.domain.MemberRequestDto
import com.cupeanimus.kotlinrestassuredtest.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/members")
@RestController
class MemberController(
    private val memberService: MemberService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun save(
        @RequestBody memberRequestDto: MemberRequestDto
    ) {
        memberService.save(memberRequestDto)
    }

}