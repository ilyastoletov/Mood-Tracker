plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.dev.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(project(":domain"))

    implementation(Dependencies.Core.ktx)
    
    implementation(Dependencies.Retrofit.core)
    implementation(Dependencies.Retrofit.converter)
    
    implementation(Dependencies.Room.core)
    implementation(Dependencies.Room.compiler)
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.kapt)
    
    implementation(Dependencies.Hilt.core)
    kapt(Dependencies.Hilt.kapt)
}