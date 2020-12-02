package com.example.consumerestkotlin

data class Value(private val id: Long, private val quote: String){

    override fun toString(): String {
        return "Value { id = $id, quote = $quote }"
    }
}