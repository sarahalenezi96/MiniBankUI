package com.coded.minibankui.branch

import androidx.lifecycle.ViewModel
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.repository.BranchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BranchViewModel : ViewModel() {
    private val _branches = MutableStateFlow(BranchRepository.branches)
    val branches: StateFlow<List<BankBranch>> = _branches
}