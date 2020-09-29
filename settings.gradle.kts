rootProject.name = "foundation"

if (gradle.parent == null) {
    includeBuild("../gradle")
}

include(
        "core",
        "dagger",
        "dagger:core",
        "test"
)

project(":dagger:core").name = "dagger-core"
