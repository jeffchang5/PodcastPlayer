package io.jeffchang.core.ktx

import android.view.View

fun View.onClick(cb: () -> Unit) {
    setOnClickListener { cb() }
}
