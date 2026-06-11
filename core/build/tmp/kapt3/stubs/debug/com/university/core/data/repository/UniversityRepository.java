package com.university.core.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/university/core/data/repository/UniversityRepository;", "", "getUniversities", "Lcom/university/core/util/Result;", "", "Lcom/university/core/domain/model/University;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
public abstract interface UniversityRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUniversities(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.university.core.util.Result<? extends java.util.List<com.university.core.domain.model.University>>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}