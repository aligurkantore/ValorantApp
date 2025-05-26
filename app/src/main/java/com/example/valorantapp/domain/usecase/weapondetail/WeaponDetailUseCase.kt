package com.example.valorantapp.domain.usecase.weapondetail

import com.example.valorantapp.common.util.onSuccess
import com.example.valorantapp.domain.mapper.toWeaponUI
import com.example.valorantapp.domain.repository.ValorantRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeaponDetailUseCase @Inject constructor(private val repository: ValorantRepository) {

    operator fun invoke(uuid: String) = flow {
        emit(
            repository.getWeaponDetails(uuid).onSuccess {
                it.weaponDetailResponseItem.toWeaponUI()
            }
        )
    }
}