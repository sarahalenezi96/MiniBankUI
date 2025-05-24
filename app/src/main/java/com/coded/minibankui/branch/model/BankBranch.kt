package com.coded.minibankui.branch.model

data class WorkingHours(
    val open: String,
    val close: String
)

data class BankBranch(
    val name: String,
    val location: String,
    val phone: String,
    val isFavorite: Boolean = false,
    val workingHours: WorkingHours
)
