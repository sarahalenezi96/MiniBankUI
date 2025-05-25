package com.coded.minibankui.branch.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.coded.minibankui.branch.model.BankBranch
import com.coded.minibankui.branch.repository.BranchRepository

class BranchViewModel : ViewModel() {
    val branches = BranchRepository.branches
    var favoriteBranch = mutableStateOf<BankBranch?>(null)

    fun toggleFavorite(branch: BankBranch) {
        favoriteBranch.value = if (favoriteBranch.value == branch) null else branch
    }

    fun isFavorite(branch: BankBranch): Boolean {
        return favoriteBranch.value == branch
    }
}