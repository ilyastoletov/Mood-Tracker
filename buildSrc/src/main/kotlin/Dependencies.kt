object Dependencies {

    object Core {
        const val ktx = "androidx.core:core-ktx:1.8.0"
        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:1.8.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val activityCompose = "androidx.activity:activity-compose:1.5.1"
        const val composeBom = "androidx.compose:compose-bom:2022.10.00"
    }

    object Compose {
        private const val version = "1.5.0"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:$version"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material3 = "androidx.compose.material3:material3:1.1.1"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val testManifest = "androidx.compose.ui:ui-test-manifest:$version"
        const val navigation = "androidx.navigation:navigation-compose:2.7.2"
        const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:2.6.2"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Room {
        private const val version = "2.5.2"
        const val core = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val kapt = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"

    }

    object Hilt {
        private const val version = "2.44"
        const val core = "com.google.dagger:hilt-android:$version"
        const val kapt = "com.google.dagger:hilt-compiler:$version"
        const val navCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }


}