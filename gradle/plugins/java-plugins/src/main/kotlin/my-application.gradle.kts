import com.jmozkji.example.gradle.JarCount

plugins {
    id("application")
    id("my-java-base")
}

tasks.register<JarCount>("countJars") {
    group = "My group"
    description = "Counts!"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("gen/count.txt"))
}

tasks.register<Zip>("bundle") {
    group = "My group"
    description = "packages it all!"

    from(tasks.jar)
    from(configurations.runtimeClasspath)

    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

    // A task registered without type will be a lifecycle task.
    // Lifecycle tasks are tasks with no action.
tasks.register("buildAll") {
    description = "Builds even more!"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}