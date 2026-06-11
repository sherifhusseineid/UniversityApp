package com.university.listing.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u001a&\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a*\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0003\u00a8\u0006\u0015"}, d2 = {"ErrorContent", "", "message", "", "onRetry", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "ListingScreen", "onNavigateToDetails", "Lkotlin/Function1;", "Lcom/university/core/domain/model/University;", "viewModel", "Lcom/university/listing/viewmodel/ListingViewModel;", "UniversityItem", "university", "onClick", "UniversityList", "universities", "", "onUniversityClick", "feature_listing_debug"})
public final class ListingScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ListingScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.university.core.domain.model.University, kotlin.Unit> onNavigateToDetails, @org.jetbrains.annotations.NotNull()
    com.university.listing.viewmodel.ListingViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void UniversityList(java.util.List<com.university.core.domain.model.University> universities, kotlin.jvm.functions.Function1<? super com.university.core.domain.model.University, kotlin.Unit> onUniversityClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void UniversityItem(com.university.core.domain.model.University university, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ErrorContent(java.lang.String message, kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, androidx.compose.ui.Modifier modifier) {
    }
}