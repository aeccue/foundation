rootProject.name = "foundation"

if (gradle.parent == null) {
    includeBuild("buildscript")
}

include(
        ":dagger",
        ":dagger:core"
)

project(":dagger:core").name = "dagger-core"
