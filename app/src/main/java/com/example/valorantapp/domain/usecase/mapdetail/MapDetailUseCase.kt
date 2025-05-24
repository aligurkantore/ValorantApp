package com.example.valorantapp.domain.usecase.mapdetail

import com.example.valorantapp.common.util.onSuccess
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MapDetailUseCase @Inject constructor(private val repository: ValorantRepository) {

    operator fun invoke(uuid: String) = flow {
        emit(
            repository.getMapDetails(uuid).onSuccess {
                it.mapDetailResponseItem
            }
        )
    }
}