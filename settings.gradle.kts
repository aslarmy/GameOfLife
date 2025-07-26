rootProject.name = "ChildEdu"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":composeApp")

include(":coreDatabase")
include(":coreNetwork")

include(":search:ui")
include(":search:data")
include(":search:domain")

include(":game:ui")
include(":game:data")
include(":game:domain")

include(":favourite:ui")
include(":favourite:data")
include(":favourite:domain")

include(":common:ui")
include(":common:data")
include(":common:domain")

