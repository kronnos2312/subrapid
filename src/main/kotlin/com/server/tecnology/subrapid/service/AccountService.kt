package com.server.tecnology.subrapid.service

import com.server.tecnology.subrapid.model.Account
import java.util.Optional

interface AccountService {
    fun findById(id:Long):Optional<Account>
    fun saveOrCreate(account:Account):Optional<Account>
    fun Create(account:Account):Account
    fun save(account:Account):Optional<Account>
    fun all():Iterable<Account>
    fun deleteById(id:Long):Optional<Account>

}