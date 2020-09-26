plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.Project.compileSdk)
    buildToolsVersion(Versions.Project.buildTool)

    defaultConfig {
        minSdkVersion(Versions.Project.minSdk)
        targetSdkVersion(Versions.Project.targetSdk)

        // environment variables
        buildConfigField("String", "BASE_URL", Constants.BASE_URL)
        buildConfigField("String", "LISTEN_NOTES_API_KEY", Keys.LISTEN_NOTES_API_KEY)

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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Deps.Square.retrofitMoshiConverter)
}

