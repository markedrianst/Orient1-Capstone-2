pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Orient 1"
//include(":app")
include(":app")
//project(":unityLibrary").projectDir = File(rootDir, "unityLibrary")
//include(":app", ":unityLibrary")
//
//include(":unityLibrary")
//include(":unityLibrary:xrmanifest.androidlib")
//include(":launcher")
