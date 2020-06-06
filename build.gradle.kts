plugins {
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlintPlugin
    id("org.jlleitschuh.gradle.ktlint-idea") version Versions.ktlintPlugin
}

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlintPlugin}")
        classpath(kotlin("gradle-plugin", version = "1.3.50"))
    }
}

ktlint {
    version.set(Versions.ktlint)
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    ignoreFailures.set(true)
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
