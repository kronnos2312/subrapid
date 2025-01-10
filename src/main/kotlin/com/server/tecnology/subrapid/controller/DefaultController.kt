package com.server.tecnology.subrapid.controller

import com.server.tecnology.subrapid.model.Account
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/default")
class DefaultController {

    @GetMapping
    fun defaultMessage(): String {
        return "Hello Word"
    }
}