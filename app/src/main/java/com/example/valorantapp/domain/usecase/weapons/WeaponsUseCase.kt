package com.example.valorantapp.domain.usecase.weapons

import androidx.paging.PagingData
import androidx.paging.map
import com.example.valorantapp.domain.mapper.mapToUIModel
import com.example.valorantapp.domain.model.weapons.WeaponUI
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeaponsUseCase @Inject constructor(private val repository: ValorantRepository) {

    suspend fun invoke(): Flow<PagingData<WeaponUI>> {
        return repository.getWeapons().map { pagingData ->
            pagingData.map { result ->
                result.mapToUIModel()
            }
        }
    }
}