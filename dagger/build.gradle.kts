subprojects {
    apply(plugin = com.aeccue.gradle.Plugins.Aeccue.DAGGER_LIBRARY)
}

dependencies {
    api(project(":dagger:dagger-core"))
}
