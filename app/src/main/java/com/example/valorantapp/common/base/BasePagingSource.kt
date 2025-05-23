package com.example.valorantapp.common.base

import androidx.paging.PagingSource
import androidx.paging.PagingState

class BasePagingSource<Value : Any>(
    val loadDataFromApi: suspend (page: Int, pageSize: Int) -> List<Value>?,
) : PagingSource<Int, Value>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val currentPage = params.key ?: STARTING_PAGE_INDEX
        println("Loading page: $currentPage, size: ${params.loadSize}")
        return try {
            val data = loadDataFromApi(currentPage, params.loadSize)
            println("Loaded ${data?.size ?: 0} items from page $currentPage")
            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = if (currentPage == STARTING_PAGE_INDEX) null else currentPage - 1,
                nextKey = if (data.isNullOrEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val STARTING_PAGE_INDEX = 1
        const val LIMIT = 20
    }
}