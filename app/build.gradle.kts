plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Versions.Project.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Project.minSdk)
        targetSdkVersion(Versions.Project.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        named("debug") {}
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

initSharedDependencies()
initTestDependencies()

dependencies {
    implementation(project(":core"))

    implementation(Deps.AndroidX.swipeRefreshLayout)
    implementation(Deps.AndroidX.navigationKtx)
    implementation(Deps.AndroidX.navigationUi)

    implementation("com.google.android.exoplayer:exoplayer:2.12.0")

    debugImplementation(Deps.Facebook.soLoader)
    debugImplementation(Deps.Facebook.flipper)

    implementation(Deps.Glide.glide)
    kapt(Deps.Glide.glideCompiler)

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

apply(plugin = "androidx.navigation.safeargs.kotlin")