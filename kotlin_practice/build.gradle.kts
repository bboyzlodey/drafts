import org.jetbrains.kotlin.base.kapt3.KaptOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.5.0"
    application
    java
}

group = "me.denis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kapt {
    generateStubs = true
}
dependencies {
    testImplementation(kotlin("test-junit"))
    implementation ("com.google.dagger:dagger:2.35")
    kapt ("com.google.dagger:dagger-compiler:2.35")
}

tasks.test {
    useJUnit()
}

tasks.clean{

}



tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}


application {
    mainClassName = "MainKt"
}