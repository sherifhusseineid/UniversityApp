# Modular MVI University App

An Android application demonstrating **Clean Architecture**, **MVI pattern**, and **multi-module** structure

---

## Architecture Overview

```
app/
 └── MainActivity (Compose NavHost + ActivityResult bridge)

feature_listing/          ← Module A (Jetpack Compose)
 ├── intent/ListingIntent
 ├── state/ListingState
 ├── viewmodel/ListingViewModel
 └── ui/ListingScreen

feature_details/          ← Module B (XML + ViewBinding)
 ├── intent/DetailsIntent
 ├── state/DetailsState
 ├── viewmodel/DetailsViewModel
 └── ui/DetailsActivity

core/
 ├── data/
 │   ├── api/          (Retrofit, DTOs)
 │   ├── db/           (Room entities, DAO, Database)
 │   ├── repository/   (interface + implementation)
 │   └── Mappers.kt
 ├── domain/
 │   ├── model/University.kt
 │   └── usecase/GetUniversitiesUseCase.kt
 ├── di/               (Hilt modules)
 └── util/Result.kt
```

### MVI Flow

```
User Action → Intent → ViewModel (processes intent) → State → UI renders state
```

Each feature has:
- **Intent** — sealed class representing user actions
- **State** — immutable data class representing the full UI state
- **ViewModel** — processes intents, invokes use cases, emits new state via `StateFlow`

### Layer Separation

| Layer        | Responsibility                                           |
|--------------|----------------------------------------------------------|
| Presentation | ViewModels, UI (Compose / XML), Intents, States          |
| Domain       | `University` model, `GetUniversitiesUseCase`             |
| Data         | Repository impl, Retrofit API, Room DB, Mappers          |

---

## Features

- **Listing Screen** (Compose): Lists all UAE universities from the API
- **Details Screen** (XML + ViewBinding): Shows full details of a selected university
- **Offline caching**: API data is stored in Room; loads from cache on network failure
- **Error state**: Shows retry button when API fails and no cache exists
- **Refresh flow**: Details → Refresh button → closes screen → listing fetches fresh data
- **No truncation**: Full university names always displayed

---

## Tech Stack

| Technology            | Purpose                        |
|-----------------------|--------------------------------|
| Kotlin                | Language                       |
| Jetpack Compose       | Listing screen UI              |
| XML + ViewBinding     | Details screen UI              |
| MVI                   | Presentation pattern           |
| Clean Architecture    | Layer separation               |
| Hilt                  | Dependency injection           |
| Retrofit + OkHttp     | Networking                     |
| Room                  | Local caching                  |
| Coroutines + Flow     | Async operations               |
| Navigation Component  | In-app routing                 |

---

## Module Structure

```
settings.gradle
├── :app             — Application entry point, DI setup, navigation host
├── :core            — Shared data/domain logic, API, Room, Hilt modules
├── :feature_listing — Compose listing screen (depends on :core)
└── :feature_details — XML details screen (depends on :core)
```

**Dependency graph:**
```
:app → :feature_listing → :core
:app → :feature_details → :core
```

---

## Data Flow

### Success path
```
ListingViewModel
  → GetUniversitiesUseCase
    → UniversityRepositoryImpl
      → Retrofit API call
      → Cache to Room DB
      → Emit List<University>
  → State(universities = [...])
  → ListingScreen renders list
```

### Failure path (with cache)
```
  → Retrofit throws exception
  → Room DAO returns cached rows
  → Emit List<University> from cache
```

### Failure path (no cache)
```
  → Retrofit throws exception
  → Room DAO returns empty list
  → Emit Result.Error(message)
  → State(error = "...") → ErrorContent shown
```

### Refresh from Details
```
DetailsActivity Refresh button
  → DetailsIntent.Refresh
  → State(navigateBackWithRefresh = true)
  → setResult(RESULT_REFRESH) + finish()
  → MainActivity ActivityResultLauncher
  → ListingViewModel.processIntent(RefreshUniversities)
  → forceRefresh = true → new API call
```

> **Note:** The app uses `http://` (cleartext traffic). Android 9+ blocks cleartext by default.
> Add this to `app/src/main/res/xml/network_security_config.xml` if needed:
> ```xml
> <?xml version="1.0" encoding="utf-8"?>
> <network-security-config>
>     <domain-config cleartextTrafficPermitted="true">
>         <domain includeSubdomains="true">universities.hipolabs.com</domain>
>     </domain-config>
> </network-security-config>
> ```
> Then reference it in the manifest:
> `android:networkSecurityConfig="@xml/network_security_config"`

---

## Running Tests

```bash
# All unit tests
./gradlew test

# Per module
./gradlew :core:test
./gradlew :feature_listing:test
./gradlew :feature_details:test
```

### Test coverage

| Module            | Tests                                             |
|-------------------|---------------------------------------------------|
| `:core`           | `UniversityRepositoryImplTest`, `GetUniversitiesUseCaseTest` |
| `:feature_listing`| `ListingViewModelTest`                            |
| `:feature_details`| `DetailsViewModelTest`                            |

---

## API

**Endpoint:** `http://universities.hipolabs.com/search?country=United%20Arab%20Emirates`
