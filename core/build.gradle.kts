plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.kotlin.ksp)
    alias(libs.plugins.kotlin.hilt)
}

android {
    namespace = "com.example.core"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }


    defaultConfig {
        minSdk = 28
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.datastore)
    implementation(libs.kotlin.serialization)

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(platform(libs.androidx.compose.bom))

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}