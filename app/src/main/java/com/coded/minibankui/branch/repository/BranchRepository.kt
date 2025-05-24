package com.coded.minibankui.branch.repository

import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.model.WorkingHours

object BranchRepository {
    val branches = listOf(
        BankBranch(
            name = "Salmiya",
            location = "Gulf Street",
            phone = "22220000",
            workingHours = WorkingHours("8:00 AM", "3:00 PM")
        ),
        BankBranch(
            name = "Sharq",
            location = "Al Shuhada Street",
            phone = "11115555",
            workingHours = WorkingHours("9:00 AM", "4:00 PM")
        ),
        BankBranch(
            name = "Hawally",
            location = "Tunisia Street",
            phone = "88883333",
            workingHours = WorkingHours("8:30 AM", "2:30 PM")
        ),
        BankBranch(
            name = "Rumithiya",
            location = "Tahir Al Baghli Street",
            phone = "77772222",
            workingHours = WorkingHours("10:00 AM", "5:00 PM")
        )
    )
}
