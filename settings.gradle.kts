plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "TerraNova"

include("config")
includeModuleBundle("server")
includeModuleBundle("event")
includeModule("network", "protocol")
includeModuleBundle("instance")

fun includeModuleBundle(name: String) {
    includeModule(name, "api")
    includeModule(name, "impl")
}

fun includeModule(name: String, sub: String) {
    include("$name:$sub")
    project(":$name:$sub").apply {
        projectDir = file("$name/$sub")
    }
}