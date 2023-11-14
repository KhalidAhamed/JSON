package com.example.paymentintegration.ModelClass

data class OrderModel(
    val consumeType: String,
    val key: Int,
    val orderDTO: OrderDTO,
    val sign: String,
    val timestamp: Long
)