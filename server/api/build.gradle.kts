plugins {
    id("com.alexsobiek.terranova.java-library-conventions")
}

dependencies {
    compileOnly(project(":event:api"))
}