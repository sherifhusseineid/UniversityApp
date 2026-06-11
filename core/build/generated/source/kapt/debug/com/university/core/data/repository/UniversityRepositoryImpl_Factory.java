package com.university.core.data.repository;

import com.university.core.data.api.UniversityApiService;
import com.university.core.data.db.UniversityDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class UniversityRepositoryImpl_Factory implements Factory<UniversityRepositoryImpl> {
  private final Provider<UniversityApiService> apiServiceProvider;

  private final Provider<UniversityDao> universityDaoProvider;

  public UniversityRepositoryImpl_Factory(Provider<UniversityApiService> apiServiceProvider,
      Provider<UniversityDao> universityDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.universityDaoProvider = universityDaoProvider;
  }

  @Override
  public UniversityRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), universityDaoProvider.get());
  }

  public static UniversityRepositoryImpl_Factory create(
      Provider<UniversityApiService> apiServiceProvider,
      Provider<UniversityDao> universityDaoProvider) {
    return new UniversityRepositoryImpl_Factory(apiServiceProvider, universityDaoProvider);
  }

  public static UniversityRepositoryImpl newInstance(UniversityApiService apiService,
      UniversityDao universityDao) {
    return new UniversityRepositoryImpl(apiService, universityDao);
  }
}
