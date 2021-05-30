package com.assignment.bigstepassignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.assignment.bigstepassignment.data.repository.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val historyRepository: HistoryRepository) : ViewModel() {

    fun getItemVisited() = historyRepository.getItemVisited()

}