plugins {
    id("com.alexsobiek.terranova.java-library-conventions")
}

dependencies {
    compileOnly(libs.nettybuffer)
    compileOnly(project(":network:protocol"))
}