plugins {
    id("application")
    id("my-java-base")
}

tasks.register<Zip>("bundle") {
    group = "My group"
    description = "packages it all!"

    from(tasks.jar)
    from(configurations.runtimeClasspath)

    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}