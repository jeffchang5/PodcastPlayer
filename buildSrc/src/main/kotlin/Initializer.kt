import ktx.api
import ktx.implementation
import ktx.kapt
import ktx.testImpl
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.initSharedDependencies() {
    dependencies {
        kapt(Deps.AndroidX.roomCompiler)
        implementation(Deps.Kotlin.stdlib)

        implementation(Deps.AndroidX.constraintLayout)
        implementation(Deps.AndroidX.appCompat)
        implementation(Deps.AndroidX.lifecycleExtensions)

        implementation(Deps.AndroidX.room)
        implementation(Deps.AndroidX.roomKtx)

        implementation(Deps.AndroidX.coreKtx)

        implementation(Deps.Google.materialComponents)

        implementation(Deps.Square.retrofit)
        implementation(Deps.Square.moshi)
        implementation(Deps.Square.moshiKotlin)

        api(Deps.Dagger.dagger)
        kapt(Deps.Dagger.compiler)
        kapt(Deps.Dagger.androidProcessor)

        implementation(Deps.JakeWharton.timber)
        implementation(Deps.JakeWharton.rxRelay)
    }
}

fun Project.initTestDependencies() {
    dependencies {
        testImpl(TestDeps.JUnit.jUnit)
        testImpl(TestDeps.Amshove.kluent)
        testImpl(TestDeps.AndroidX.coreTesting)

        testImpl(Deps.Mockito.mockito)
        testImpl(Deps.JUnit.jUnit)
        testImpl(Deps.Nhaarman.mockitoKotlin2)
    }
}
