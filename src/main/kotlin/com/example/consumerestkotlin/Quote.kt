package com.example.consumerestkotlin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(val type: String, val value: Value){

    override fun toString(): String {
        return "Quote { type= $type, value = $value }"
    }
}