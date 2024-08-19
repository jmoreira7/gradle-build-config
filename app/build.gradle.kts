plugins {
    id("my-application")
}

application {
    mainClass.set("com.jmozkji.example.MyAplication")
}

dependencies {
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
}