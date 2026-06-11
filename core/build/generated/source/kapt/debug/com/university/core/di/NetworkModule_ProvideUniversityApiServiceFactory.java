package com.university.core.di;

import com.university.core.data.api.UniversityApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideUniversityApiServiceFactory implements Factory<UniversityApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideUniversityApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public UniversityApiService get() {
    return provideUniversityApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideUniversityApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideUniversityApiServiceFactory(retrofitProvider);
  }

  public static UniversityApiService provideUniversityApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideUniversityApiService(retrofit));
  }
}
