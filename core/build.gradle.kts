dependencies {
    api(com.aeccue.gradle.Dependencies.Security.ARGON2)
    api(com.aeccue.gradle.Dependencies.Util.JAVA_MAIL)
    api(com.aeccue.gradle.Dependencies.Util.JSON_SIMPLE)
    testImplementation(project(":test"))
}
