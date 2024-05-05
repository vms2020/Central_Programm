import com.android.build.gradle.internal.packaging.defaultExcludes
import org.jetbrains.kotlin.js.inline.clean.removeDuplicateImports

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.one.two.centralprogramm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.one.two.centralprogramm"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //implementation(files("../libfetch/lib/build/libs/lib-fat.jar"))
    implementation(group="org.example",name="lib",ext="jar")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:2.3.10")
    implementation ("io.ktor:ktor-client-android:2.3.10")
    implementation ("io.ktor:ktor-client-content-negotiation:2.3.10")
    implementation ("io.ktor:ktor-client-logging:2.3.10")
    implementation ("org.slf4j:slf4j-simple:2.0.13")
    implementation(kotlin("reflect"))


    //{
//        exclude(group: "com.google.android.gms", module: "play-services-measurement-base")
    //  }


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}

tasks.create<Exec>("MyTask") {
    commandLine("./gradlew", "jar")
        .setWorkingDir("$rootDir/libfetch")
}
