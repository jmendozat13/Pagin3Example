package com.example.android.codelabs.paging.data.source.common

interface DomainMapper<T : Any> {
    fun mapToDomainEntity(): T
}