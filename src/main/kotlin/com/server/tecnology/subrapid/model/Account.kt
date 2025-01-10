package com.server.tecnology.subrapid.model

import com.server.tecnology.subrapid.dto.AccountDTO
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="account")
data class Account(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id var id:Long?,
                   var name:String,
                   var email:String,
                   var createAt: Date
){
    constructor():this(null, "","", Date())
    constructor(accountDTO: AccountDTO):this(accountDTO.id, accountDTO.name,accountDTO.email, accountDTO.createAt)
}
