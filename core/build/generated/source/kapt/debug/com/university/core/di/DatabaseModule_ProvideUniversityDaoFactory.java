package com.university.core.di;

import com.university.core.data.db.UniversityDao;
import com.university.core.data.db.UniversityDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideUniversityDaoFactory implements Factory<UniversityDao> {
  private final Provider<UniversityDatabase> databaseProvider;

  public DatabaseModule_ProvideUniversityDaoFactory(Provider<UniversityDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UniversityDao get() {
    return provideUniversityDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideUniversityDaoFactory create(
      Provider<UniversityDatabase> databaseProvider) {
    return new DatabaseModule_ProvideUniversityDaoFactory(databaseProvider);
  }

  public static UniversityDao provideUniversityDao(UniversityDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUniversityDao(database));
  }
}
