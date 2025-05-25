package com.coded.minibankui.branch.repository

import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.model.WorkingHours

object BranchRepository {
    val branches = listOf(
        BankBranch(
            id = 1,
            name = "Hawally",
            type = "Branch",
            address = "Tunisia St.",
            phone = "1801801",
            workingHours = WorkingHours(open = "8:30 AM", close = "3:30 PM"),
            location = "https://g.co/kgs/iYqgzXT",
            imageUri = "https://raw.githubusercontent.com/sarahalenezi96/MiniBankUI/main/branch_images/hawally_branch.png"
        ),
        BankBranch(
            id = 2,
            name = "Sharq",
            type = "Headquarters",
            address = "Al Shuhada St.",
            phone = "1801801",
            workingHours = WorkingHours(open = "9:00 AM", close = "4:00 PM"),
            location = "https://g.co/kgs/KhuUvJ8",
            imageUri = "https://raw.githubusercontent.com/sarahalenezi96/MiniBankUI/main/branch_images/sharq_hq.png"
        ),
        BankBranch(
            id = 3,
            name = "Rumithiya",
            type = "Branch",
            address = "Muath Bin Jabal St.",
            phone = "1801801",
            workingHours = WorkingHours(open = "9:00 AM", close = "2:00 PM"),
            location = "https://g.co/kgs/mbR7ocS",
            imageUri = "https://raw.githubusercontent.com/sarahalenezi96/MiniBankUI/main/branch_images/rumaithiya_branch.png"
        ),
        BankBranch(
            id = 4,
            name = "Salmiya",
            type = "Branch",
            address = "Salem Al Mubarak St.",
            phone = "1801801",
            workingHours = WorkingHours(open = "8:00 AM", close = "3:00 PM"),
            location = "https://g.co/kgs/mGcKtLz",
            imageUri = "https://raw.githubusercontent.com/sarahalenezi96/MiniBankUI/main/branch_images/salmiya_branch.png"
    )
    )
}
