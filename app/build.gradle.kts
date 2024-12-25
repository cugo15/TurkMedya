plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.turkmedya"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.turkmedya"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

// Fragment KTX: Kotlin ile daha kolay fragment kullanımı
    implementation("androidx.fragment:fragment-ktx:1.8.5")

    // Fragment Testing: Fragment testleri için destek
    debugImplementation("androidx.fragment:fragment-testing:1.8.5")

    // Navigation Fragment: Navigasyon için fragment desteği
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.4")

    // Navigation UI: Navigasyon arayüzü bileşenleri
    implementation("androidx.navigation:navigation-ui-ktx:2.8.4")

    // Dynamic Features: Dinamik özellik desteği
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.8.4")

    // Navigation Testing: Navigasyon testleri için
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.4")

    //Görsel Yükleme: Glide kütüphanesi
    implementation("com.github.bumptech.glide:glide:4.16.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    implementation ("androidx.media3:media3-exoplayer:1.5.1")
    implementation ("androidx.media3:media3-ui:1.5.1")
    implementation ("androidx.media3:media3-exoplayer-hls:1.0.0")
    implementation ("com.google.code.gson:gson:2.10.1")

    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")


}
kapt {
    correctErrorTypes = true
}