package io.jeffchang.core.ktx

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

operator fun <T> LiveData<T>.invoke(viewLifecycleOwner: LifecycleOwner, function: (T) -> Unit) {
    observe(viewLifecycleOwner, Observer {
        function(it)
    })
}
