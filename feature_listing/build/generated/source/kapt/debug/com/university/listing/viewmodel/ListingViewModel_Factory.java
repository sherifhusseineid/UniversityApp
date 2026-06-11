package com.university.listing.viewmodel;

import com.university.core.domain.usecase.GetUniversitiesUseCase;
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
public final class ListingViewModel_Factory implements Factory<ListingViewModel> {
  private final Provider<GetUniversitiesUseCase> getUniversitiesUseCaseProvider;

  public ListingViewModel_Factory(Provider<GetUniversitiesUseCase> getUniversitiesUseCaseProvider) {
    this.getUniversitiesUseCaseProvider = getUniversitiesUseCaseProvider;
  }

  @Override
  public ListingViewModel get() {
    return newInstance(getUniversitiesUseCaseProvider.get());
  }

  public static ListingViewModel_Factory create(
      Provider<GetUniversitiesUseCase> getUniversitiesUseCaseProvider) {
    return new ListingViewModel_Factory(getUniversitiesUseCaseProvider);
  }

  public static ListingViewModel newInstance(GetUniversitiesUseCase getUniversitiesUseCase) {
    return new ListingViewModel(getUniversitiesUseCase);
  }
}
