package com.university.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/university/core/data/repository/UniversityRepositoryImpl;", "Lcom/university/core/data/repository/UniversityRepository;", "apiService", "Lcom/university/core/data/api/UniversityApiService;", "universityDao", "Lcom/university/core/data/db/UniversityDao;", "(Lcom/university/core/data/api/UniversityApiService;Lcom/university/core/data/db/UniversityDao;)V", "getUniversities", "Lcom/university/core/util/Result;", "", "Lcom/university/core/domain/model/University;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public final class UniversityRepositoryImpl implements com.university.core.data.repository.UniversityRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.university.core.data.api.UniversityApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.university.core.data.db.UniversityDao universityDao = null;
    
    @javax.inject.Inject()
    public UniversityRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.university.core.data.api.UniversityApiService apiService, @org.jetbrains.annotations.NotNull()
    com.university.core.data.db.UniversityDao universityDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUniversities(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.university.core.util.Result<? extends java.util.List<com.university.core.domain.model.University>>> $completion) {
        return null;
    }
}