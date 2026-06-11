package com.university.details.ui;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/university/details/ui/DetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/university/details/databinding/ActivityDetailsBinding;", "viewModel", "Lcom/university/details/viewmodel/DetailsViewModel;", "getViewModel", "()Lcom/university/details/viewmodel/DetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeState", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "renderUniversity", "university", "Lcom/university/core/domain/model/University;", "setupListeners", "Companion", "feature_details_debug"})
public final class DetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.university.details.databinding.ActivityDetailsBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_UNIVERSITY = "extra_university";
    public static final int RESULT_REFRESH = 100;
    @org.jetbrains.annotations.NotNull()
    public static final com.university.details.ui.DetailsActivity.Companion Companion = null;
    
    public DetailsActivity() {
        super();
    }
    
    private final com.university.details.viewmodel.DetailsViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupListeners() {
    }
    
    private final void observeState() {
    }
    
    private final void renderUniversity(com.university.core.domain.model.University university) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/university/details/ui/DetailsActivity$Companion;", "", "()V", "EXTRA_UNIVERSITY", "", "RESULT_REFRESH", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "university", "Lcom/university/core/domain/model/University;", "feature_details_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent createIntent(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.university.core.domain.model.University university) {
            return null;
        }
    }
}