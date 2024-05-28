package com.oybekdev.android_architecture.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oybekdev.android_architecture.util.EventBus
import kotlinx.coroutines.launch


fun ViewModel.sendEvent(event: Any) {
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}