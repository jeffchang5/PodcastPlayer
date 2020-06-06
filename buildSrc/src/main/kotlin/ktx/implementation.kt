package ktx

import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(dep: String) {
    add("implementation", dep)
}

fun DependencyHandlerScope.testImpl(dep: String) {
    add("testImplementation", dep)
}

fun DependencyHandlerScope.kapt(dep: String) {
    add("kapt", dep)
}

fun DependencyHandlerScope.api(dep: String) {
    add("api", dep)
}