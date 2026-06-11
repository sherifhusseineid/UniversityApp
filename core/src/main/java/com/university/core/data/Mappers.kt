package com.university.core.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.university.core.data.api.UniversityDto
import com.university.core.data.db.UniversityEntity
import com.university.core.domain.model.University

private val gson = Gson()
private val listType = object : TypeToken<List<String>>() {}.type

fun UniversityDto.toDomain(): University = University(
    name = name,
    country = country,
    alphaTwoCode = alphaTwoCode,
    stateProvince = stateProvince?:"",
    domains = domains,
    webPages = webPages
)

fun UniversityDto.toEntity(): UniversityEntity = UniversityEntity(
    name = name,
    country = country,
    alphaTwoCode = alphaTwoCode,
    stateProvince = stateProvince,
    domains = gson.toJson(domains),
    webPages = gson.toJson(webPages)
)

fun UniversityEntity.toDomain(): University = University(
    name = name,
    country = country,
    alphaTwoCode = alphaTwoCode,
    stateProvince = stateProvince?:"",
    domains = gson.fromJson(domains, listType),
    webPages = gson.fromJson(webPages, listType)
)
