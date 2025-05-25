package com.coded.minibankui.branch.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WorkingHours(
    val open: String,
    val close: String
) : Parcelable

@Parcelize
data class BankBranch(
    val id: Int,
    val name: String,
    val type: String,
    val address: String,
    val phone: String,
    val workingHours: WorkingHours,
    val location: String,
    val imageUri: String
) : Parcelable
