package com.university.listing.intent

sealed class ListingIntent {
    object LoadUniversities : ListingIntent()
    object RefreshUniversities : ListingIntent()
    data class SelectUniversity(val universityName: String) : ListingIntent()
}
