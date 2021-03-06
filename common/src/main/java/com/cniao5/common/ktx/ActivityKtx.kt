package com.cniao5.common.ktx

import androidx.core.app.ComponentActivity
import androidx.lifecycle.LifecycleOwner

/**
 * 扩展lifeCycleOwner属性，便于和Fragment之间使用lifeCycleOwner 一致性
 */
val ComponentActivity.viewLifeCycleOwner: LifecycleOwner
    get() = this