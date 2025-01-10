package com.server.tecnology.subrapid.controller

import com.server.tecnology.subrapid.dto.AccountDTO
import com.server.tecnology.subrapid.model.Account
import com.server.tecnology.subrapid.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("api/account")
class AccountController(@Autowired private val accountService: AccountService) {

    @PostMapping
    fun create(@RequestBody account: AccountDTO): ResponseEntity<AccountDTO> {
        return ResponseEntity.ok(AccountDTO(accountService.Create(Account(account)),"New","200") )
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<AccountDTO>{
        val account = accountService.findById(id)
        if (account.isPresent) {
            accountService.deleteById(id)
            return ResponseEntity.ok(AccountDTO(account.get(),"delete","200"))
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND,"Accout not Found by: $id ")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<AccountDTO>{
        val account = accountService.findById(id)
        if (account.isPresent) {
            return ResponseEntity.ok(AccountDTO(account.get(),"Found","200"))
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND,"Accout not Found by: $id ")
    }

    @GetMapping
    fun findAll(): ResponseEntity<Iterable<Account>>  {
        return ResponseEntity.ok(accountService.all())
    }
}