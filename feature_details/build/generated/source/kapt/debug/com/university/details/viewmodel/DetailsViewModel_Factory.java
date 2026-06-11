package com.university.details.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class DetailsViewModel_Factory implements Factory<DetailsViewModel> {
  @Override
  public DetailsViewModel get() {
    return newInstance();
  }

  public static DetailsViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DetailsViewModel newInstance() {
    return new DetailsViewModel();
  }

  private static final class InstanceHolder {
    private static final DetailsViewModel_Factory INSTANCE = new DetailsViewModel_Factory();
  }
}
