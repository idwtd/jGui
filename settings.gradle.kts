pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        jcenter()
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.replaymod.preprocess" -> {
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }
}

rootProject.name = "jGui"

listOf(
        "1.7.10",
        "1.8",
        "1.8.9",
        "1.9.4",
        "1.12",
        "1.14.4-forge",
        "1.14.4",
        "1.15.2",
        "1.16.1",
        "1.16.4"
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../common.gradle"
    }
}

