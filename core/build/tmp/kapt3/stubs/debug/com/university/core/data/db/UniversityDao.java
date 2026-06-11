package com.university.core.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/university/core/data/db/UniversityDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllUniversities", "", "Lcom/university/core/data/db/UniversityEntity;", "insertAll", "universities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_debug"})
@androidx.room.Dao()
public abstract interface UniversityDao {
    
    @androidx.room.Query(value = "SELECT * FROM universities ORDER BY name ASC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllUniversities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.university.core.data.db.UniversityEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.university.core.data.db.UniversityEntity> universities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM universities")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}