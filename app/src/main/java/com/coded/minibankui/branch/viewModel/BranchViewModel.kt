package com.coded.minibankui.branch.viewModel

import androidx.lifecycle.ViewModel
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.repository.BranchRepository

class BranchViewModel : ViewModel() {
    val branches: List<BankBranch> = BranchRepository.branches
}