rootProject.name = "foundation"

if (gradle.parent == null) {
    includeBuild("buildscript")
}

include(
        ":dagger"
)
