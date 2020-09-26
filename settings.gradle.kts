rootProject.name = "foundation"

if (gradle.parent == null) {
    includeBuild("../gradle")
}

include(
        "dagger",
        "dagger:core"
)

project(":dagger:core").name = "dagger-core"
