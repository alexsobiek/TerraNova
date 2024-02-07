plugins {
    id("com.alexsobiek.terranova.java-application-conventions")
}

dependencies {
    implementation(project(":config"))
    implementation(project(":server:api"))
    implementation(project(":event:impl"))
}

application {
    mainClass.set("com.alexsobiek.terranova.Bootstrap")
}
