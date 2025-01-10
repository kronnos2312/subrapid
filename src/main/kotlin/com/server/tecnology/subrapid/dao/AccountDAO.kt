package com.server.tecnology.subrapid.dao

import com.server.tecnology.subrapid.model.Account
import org.springframework.data.repository.CrudRepository

interface AccountDAO : CrudRepository<Account, Long>