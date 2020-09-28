package com.example.android.codelabs.paging.domain.usecases

import com.example.android.codelabs.paging.data.source.database.model.PagingInfoModel
import com.example.android.codelabs.paging.domain.repository.IPagingInfoRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.inject

class GetPagingInfoUseCase : BaseUseCase() {
    private val pagingRepository: IPagingInfoRepository by inject()
    operator fun invoke(source: String): Flow<PagingInfoModel> = pagingRepository.getPagingInfo(source)
}