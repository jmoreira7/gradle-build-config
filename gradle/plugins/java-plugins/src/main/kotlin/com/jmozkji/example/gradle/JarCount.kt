package com.jmozkji.example.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.nio.file.Files
import java.util.Collections

/* @CacheableTask
        Sometimes there are cases where writing and retrieving from the cache is considered more expensive than the
        actual task action.
        In this case, tasks are explicitly not made cacheable.
 */
abstract class JarCount : DefaultTask() {

    /* Gradle specific types:
        ConfigurableFileCollection <- @InputFiles
        RegularFileProperty <- @InputFile
        DirectoryProperty <- @InputDirectory
     */

    @get:InputFiles
    abstract val allJars: ConfigurableFileCollection

    @get:OutputFile
    abstract val countFile: RegularFileProperty

    @TaskAction
    fun doCount() {
        val jarFiles: Set<File> = allJars.files

        val count = jarFiles.size

        val out: File = countFile.get().asFile

        Files.write(out.toPath(), Collections.singleton("" + count))
    }
}