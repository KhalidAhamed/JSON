package com.example.paymentintegration.ModelClass

data class OrderDTO(
    val consumeType: String,
    val order: Order,
    val orderGoodsDetailList: List<OrderGoodsDetail>,
    val payType: Int
)