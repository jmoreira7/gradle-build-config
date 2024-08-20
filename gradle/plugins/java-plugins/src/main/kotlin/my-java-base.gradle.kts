plugins {
    id("java")
    id("com.diffplug.spotless")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

    /* The block 'tasks.withType<JavaCompile>().configureEach' does the same of:
        tasks.named<JavaCompile>("compileJava") { // == tasks.compileJava {}
            options.encoding = "UTF-8"
        }

        tasks.compileTestJava {
            options.encoding = "UTF-8"
        }
    */
tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.test {

}