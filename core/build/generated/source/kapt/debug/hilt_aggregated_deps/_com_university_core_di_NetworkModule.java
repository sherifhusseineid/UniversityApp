package hilt_aggregated_deps;

import dagger.hilt.processor.internal.aggregateddeps.AggregatedDeps;
import javax.annotation.processing.Generated;

/**
 * This class should only be referenced by generated code! This class aggregates information across multiple compilations.
 */
@AggregatedDeps(
    components = "dagger.hilt.components.SingletonComponent",
    modules = "com.university.core.di.NetworkModule"
)
@Generated("dagger.hilt.processor.internal.aggregateddeps.AggregatedDepsGenerator")
public class _com_university_core_di_NetworkModule {
}
