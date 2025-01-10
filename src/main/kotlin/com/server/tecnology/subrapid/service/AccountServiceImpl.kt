package com.server.tecnology.subrapid.service

import com.server.tecnology.subrapid.dao.AccountDAO
import com.server.tecnology.subrapid.model.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountServiceImpl(@Autowired private val accountDAO: AccountDAO):AccountService {
    override fun findById(id: Long): Optional<Account> {
        return accountDAO.findById(id)
    }

    override fun saveOrCreate(account: Account): Optional<Account> {
        val savedAccount = accountDAO.save(account)
        return Optional.of(savedAccount)
    }

    override fun Create(account: Account): Account {
        return  accountDAO.save(account)
    }

    override fun save(account: Account): Optional<Account> {
        val savedAccount = accountDAO.save(account)
        return Optional.of(savedAccount)
    }

    override fun all(): Iterable<Account> {
        return accountDAO.findAll()
    }

    override fun deleteById(id: Long): Optional<Account> {
        val account = accountDAO.findById(id)
        if (account.isPresent) {
            accountDAO.deleteById(id)
        }
        return account
    }
}