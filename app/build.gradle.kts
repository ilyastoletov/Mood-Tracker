plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.dev.moodtracker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dev.moodtracker"
        minSdk = 24
        targetSdk = 33
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.Core.ktx)
    implementation(Dependencies.Core.kotlinBom)
    implementation(Dependencies.Core.activityCompose)
    implementation(Dependencies.Core.composeBom)
    implementation(Dependencies.Core.lifecycleRuntime)
    
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.navigation)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.testManifest)

}