rootProject.name = "foundation"

if (gradle.parent == null) {
    includeBuild("../gradle")
}

include(
        "api",
        "core",
        "dagger",
        "dagger:core",
        "test"
)

project(":dagger:core").name = "dagger-core"
