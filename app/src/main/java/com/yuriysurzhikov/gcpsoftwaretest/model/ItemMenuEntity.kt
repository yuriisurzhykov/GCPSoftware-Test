package com.yuriysurzhikov.gcpsoftwaretest.model

import com.google.gson.annotations.SerializedName

data class ItemMenuEntity(
    val name: String,
    val function: FunctionType
)

sealed class FunctionType(val param: String) {
    constructor(): this("")
    class Text(param: String): FunctionType(param)
    class Image(param: String): FunctionType(param)
    class Url(param: String): FunctionType(param)
}