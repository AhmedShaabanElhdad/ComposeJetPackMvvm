package com.example.composejetpackmvvmproject.domain.utility

interface DomainMapper<T, DomainModel> {
    fun mapFromDomainModel(model: T): DomainModel
    fun mapToDomainModel(domainModel: DomainModel): T
}