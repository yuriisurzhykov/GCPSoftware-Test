package com.yuriysurzhikov.gcpsoftwaretest.repository.retrofit

import com.google.gson.annotations.SerializedName
import com.yuriysurzhikov.gcpsoftwaretest.model.ItemMenuEntity

data class Menu(
    @SerializedName("menu")
    val items: List<MenuItemNetworkEntity>
)