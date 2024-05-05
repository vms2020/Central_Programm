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
    //repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)

    repositories {
        flatDir {
            dirs(rootDir.absolutePath +"/libfetch/lib/build/libs")
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "Central Programm"
include(":app")
//include(":libfetch:lib")
//project(":libfetch").projectDir=file(File(rootDir,"libfetch"))

