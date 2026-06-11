package com.university.core.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/university/core/data/db/UniversityDatabase;", "Landroidx/room/RoomDatabase;", "()V", "universityDao", "Lcom/university/core/data/db/UniversityDao;", "core_debug"})
@androidx.room.Database(entities = {com.university.core.data.db.UniversityEntity.class}, version = 1, exportSchema = false)
public abstract class UniversityDatabase extends androidx.room.RoomDatabase {
    
    public UniversityDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.university.core.data.db.UniversityDao universityDao();
}