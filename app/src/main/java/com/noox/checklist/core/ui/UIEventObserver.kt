package com.noox.checklist.core.ui

import androidx.lifecycle.Observer

/**
 * An [Observer] for [UIEvent]s, simplifying the pattern of checking if the [UIEvent]'s content has
 * already been consumed.
 *
 * [onEventUnconsumedContent] is *only* called if the [UIEvent]'s contents has not been consumed.
 */
class UIEventObserver<T>(private val onEventUnconsumedContent: (T) -> Unit) : Observer<UIEvent<T>> {
    override fun onChanged(event: UIEvent<T>?) {
        event?.consume()?.run(onEventUnconsumedContent)
    }
}
