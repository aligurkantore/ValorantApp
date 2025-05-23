package com.example.valorantapp.common.network

import com.example.valorantapp.common.util.FailViewType

class PagingFail(override val message: String, val failViewType: FailViewType) : Exception(message)