object Deps {

    object Facebook {
        const val flipper = "com.facebook.flipper:flipper:${Versions.Facebook.flipper}"
        const val soLoader = "com.facebook.soloader:soloader:${Versions.Facebook.soLoader}"
        const val networkFlipperPlugin =
            "com.facebook.flipper:flipper-network-plugin:${Versions.Facebook.flipper}"
    }

    object AndroidX {
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.AndroidX.swipeRefreshLayout}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}"
        const val navigationKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidX.navigation}"
        const val navigationUi =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.navigation}"
        const val ViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.viewmodelKtx}"

        const val lifecycleExtensions =
            "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifecycle}"

        const val room = "androidx.room:room-runtime:${Versions.AndroidX.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.AndroidX.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.AndroidX.room}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
    }

    object Google {
        const val materialComponents =
            "com.google.android.material:material:${Versions.Google.materialComponents}"
    }

    object Square {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Square.retrofit}"
        const val moshi = "com.squareup.moshi:moshi:${Versions.Square.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.Square.moshiKotlin}"
        const val retrofitMoshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.Square.moshiRetrofitConverter}"
    }

    object JakeWharton {
        const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.JakeWharton.rxRelay}"
        const val timber = "com.jakewharton.timber:timber:${Versions.JakeWharton.timber}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.kotlin}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.Dagger.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.Dagger.dagger}"
        const val androidProcessor =
            "com.google.dagger:dagger-android-processor:${Versions.Dagger.dagger}"
    }

    object Mockito {

        const val mockito = "org.mockito:mockito-core:${Versions.Mockito.mockito}"
    }

    object JUnit {
        const val jUnit = "junit:junit:${Versions.JUnit.jUnit}"
    }

    object Nhaarman {
        const val mockitoKotlin2 =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Nhaarman.mockitoKotlin2}"
    }

    object Glide {
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Glide.glide}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.Glide.glide}"
    }
}