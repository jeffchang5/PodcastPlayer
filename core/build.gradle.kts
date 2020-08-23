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
        buildConfigField("String", "BASE_URL", Constants.YELP_API_URL)

        buildConfigField("String", "YELP_CLIENT_ID",  "\"YsV0rAlfBOmd7u13b6B9mw\"")
        buildConfigField("String", "YELP_API_KEY", "\"-9J7CMgoCAuwJE--lnJyIp2juAIEyg6tJpfB7dGUDRfSj2DnP_Cg-QWusETJ2YiAF0NiR17tQ1wtPdRv_o0pouaOnf322FPQy6LCANIrYwWDzJRD8pFGL6W3KEtAX3Yx\"")

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

