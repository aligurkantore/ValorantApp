package com.example.valorantapp.domain.usecase.maps

import androidx.paging.PagingData
import androidx.paging.map
import com.example.valorantapp.domain.mapper.toUIModel
import com.example.valorantapp.domain.model.maps.MapUIModel
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MapsUseCase @Inject constructor(private val repository: ValorantRepository) {

    suspend fun invoke(): Flow<PagingData<MapUIModel>> {
        return repository.getMaps().map { pagingData ->
            pagingData.map { result ->
                result.toUIModel()
            }
        }
    }
}