package com.university.details.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/university/details/viewmodel/DetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/university/details/state/DetailsState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "onNavigationHandled", "", "processIntent", "intent", "Lcom/university/details/intent/DetailsIntent;", "setUniversity", "university", "Lcom/university/core/domain/model/University;", "feature_details_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.university.details.state.DetailsState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.university.details.state.DetailsState> state = null;
    
    @javax.inject.Inject()
    public DetailsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.university.details.state.DetailsState> getState() {
        return null;
    }
    
    public final void setUniversity(@org.jetbrains.annotations.NotNull()
    com.university.core.domain.model.University university) {
    }
    
    public final void processIntent(@org.jetbrains.annotations.NotNull()
    com.university.details.intent.DetailsIntent intent) {
    }
    
    public final void onNavigationHandled() {
    }
}