package com.yuriysurzhikov.gcpsoftwaretest.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.yuriysurzhikov.gcpsoftwaretest.model.FunctionType
import com.yuriysurzhikov.gcpsoftwaretest.model.ItemMenuEntity
import com.yuriysurzhikov.gcpsoftwaretest.repository.retrofit.Menu
import com.yuriysurzhikov.gcpsoftwaretest.repository.retrofit.FileService
import com.yuriysurzhikov.gcpsoftwaretest.repository.retrofit.MenuItemNetworkMapper
import com.yuriysurzhikov.gcpsoftwaretest.utils.DataState
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.ResponseBody
import java.io.IOException

class MainRepository
constructor(
    @ApplicationContext private val context: Context,
    private val fileService: FileService,
    private val menuItemNetworkMapper: MenuItemNetworkMapper
){
    suspend fun getMenuItems(): Flow<DataState<List<ItemMenuEntity>>> = flow {
        emit(DataState.Loading)
        try {
            val stringResult = getStringFromBodyStream(fileService.getJSONObject())
            val list = Gson().fromJson(stringResult, Menu::class.java)
            val resultList = menuItemNetworkMapper.mapFromEntityList(list.items)
            emit(DataState.Success(resultList))
        } catch (ex: Exception) {
            val list = listOf(ItemMenuEntity("Item 1", FunctionType.Text("There is no connection to the internet")))
            emit(DataState.Success(list))
        }
    }

    private fun getStringFromBodyStream(body: ResponseBody): String {
        return try {
            String(body.byteStream().readBytes())
        } catch (e: IOException) {
            String()
        }
    }

    companion object {
        const val TAG = "MainRepository"
    }
}