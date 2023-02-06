buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        // these should be full path in root build.gradle.kts
        classpath(com.example.buildSrc.properties.Dependency.ClassPath.androidGradle)
        classpath(com.example.buildSrc.properties.Dependency.ClassPath.kotlin)
        classpath(com.example.buildSrc.properties.Dependency.ClassPath.ksp)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    }
}

//allprojects {
//    repositories {
//        google()
//        jcenter()
//    }
//}
