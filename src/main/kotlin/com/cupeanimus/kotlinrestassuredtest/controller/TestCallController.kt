package com.cupeanimus.kotlinrestassuredtest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/test")
@RestController
class TestCallController {

    @GetMapping
    fun get(): String {
        return "ok"
    }
}