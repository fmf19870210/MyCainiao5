package com.cniao5.common.network.model

/**
 *
 * 基础的网络返回数据结构
 *
 *
 */
   class NetResponse{
    var code: Int?=0//响应码
    var data: Any?=null//响应数据内容
    var message: String?=null//响应数据的结果描述
}