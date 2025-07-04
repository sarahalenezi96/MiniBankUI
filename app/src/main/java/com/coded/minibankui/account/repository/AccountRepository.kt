package com.coded.minibankui.account.repository

import com.coded.minibankui.account.model.Account

object AccountRepository {
    val accountsList = listOf(
        Account("Salary", 1400.00, "KWD"),
        Account("Savings", 230.75, "KWD"),
        Account("Travel", 720.00, "KWD"),
        Account("Kids", 312.00, "KWD")
    )
}
