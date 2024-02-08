plugins {
    id("com.alexsobiek.terranova.java-library-conventions")
}

dependencies {
    implementation(libs.netty)
    compileOnly(project(":network:protocol"))
    compileOnly(project(":network:api"))
}