package com.cniao5.common.utils

import com.cniao5.common.BuildConfig

/**
 * 作者： 志威  zhiwei.org
 * 主页： Github: https://github.com/zhiwei1990
 * 日期： 2020年04月27日 14:51
 * 签名： 天行健，君子以自强不息；地势坤，君子以厚德载物。
 *      _              _           _     _   ____  _             _ _
 *     / \   _ __   __| |_ __ ___ (_) __| | / ___|| |_ _   _  __| (_) ___
 *    / _ \ | '_ \ / _` | '__/ _ \| |/ _` | \___ \| __| | | |/ _` | |/ _ \
 *   / ___ \| | | | (_| | | | (_) | | (_| |  ___) | |_| |_| | (_| | | (_) |
 *  /_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |____/ \__|\__,_|\__,_|_|\___/  -- 志威 zhiwei.org
 *
 * You never know what you can do until you try !
 * ----------------------------------------------------------------
 * 基础baseUrl的配置，可用于dokit的serverHost
 */

/**
 * 获取当前配置的baseHost
 */
fun getBaseHost(): String {
    return if (BuildConfig.DEBUG) {
        CniaoSpUtils.getString(SP_KEY_BASE_HOST) ?: HOST_PRODUCT
    } else {
        HOST_PRODUCT
    }
}

/**
 * 更新配置host
 */
fun setBaseHost(host: String) {
    CniaoSpUtils.put(SP_KEY_BASE_HOST, host)
}


//配置host的key
private const val SP_KEY_BASE_HOST = "sp_key_base_host"

//不同的baseHost，这里演示，所以都写一样的了，
const val HOST_DEV = "https://course.api.cniao5.com/"//开发环境下的host配置
const val HOST_QA = "https://course.api.cniao5.com/"//qa环境的host配置
const val HOST_PRODUCT = "https://course.api.cniao5.com/"//正式配置host