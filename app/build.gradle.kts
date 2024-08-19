plugins {
    id("my-application")
}

application {
    mainClass.set("com.jmozkji.example.MyApplication")
}

dependencies {
    implementation(project(":data-model"))
    implementation(project(":business-logic"))
}