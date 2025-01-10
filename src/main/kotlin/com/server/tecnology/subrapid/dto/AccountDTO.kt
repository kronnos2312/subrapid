package com.server.tecnology.subrapid.dto

import com.server.tecnology.subrapid.model.Account
import java.util.*

data class AccountDTO(val id:Long?,
                      val name:String,
                      val email:String,
                      val createAt: Date,
                      val message:String,
                      val result:String
): RequestDTO(message, result) {
    constructor():this (null,"","",Date(),"","")
    constructor(account: Account,message: String, result: String):this (account.id,account.name,account.email,account.createAt,message,result)
}