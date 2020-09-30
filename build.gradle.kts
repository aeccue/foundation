group = "com.aeccue"
version = "0.0.1"

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.aeccue:gradle:0.1.2")
    }
}

apply(plugin = com.aeccue.gradle.Plugins.Aeccue.PROJECT_KOTLIN)

subprojects {
    group = "${rootProject.group}.foundation"
    version = rootProject.version

    if (name != "test") {
        afterEvaluate {
            dependencies {
                "testImplementation"(project(":test"))
            }
        }
    }
}
