package com.university.core.domain.usecase;

import com.university.core.data.repository.UniversityRepository;
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
public final class GetUniversitiesUseCase_Factory implements Factory<GetUniversitiesUseCase> {
  private final Provider<UniversityRepository> repositoryProvider;

  public GetUniversitiesUseCase_Factory(Provider<UniversityRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetUniversitiesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetUniversitiesUseCase_Factory create(
      Provider<UniversityRepository> repositoryProvider) {
    return new GetUniversitiesUseCase_Factory(repositoryProvider);
  }

  public static GetUniversitiesUseCase newInstance(UniversityRepository repository) {
    return new GetUniversitiesUseCase(repository);
  }
}
