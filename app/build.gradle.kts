plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")

    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "kz.sd.apteka"
    compileSdk = 34

    defaultConfig {
        applicationId = "kz.sd.apteka"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation ("com.github.bumptech.glide:glide:4.13.0")



    implementation ("androidx.fragment:fragment-ktx:1.2.5")

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

    implementation ("com.google.android.material:material:1.10.0")

    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.firebase:firebase-auth")

    implementation("com.google.dagger:hilt-android:2.46")
    implementation ("com.airbnb.android:lottie:5.2.0")
    implementation("com.google.firebase:firebase-database-ktx:20.3.1")
    implementation("com.google.firebase:firebase-storage-ktx:20.3.0")
    kapt ("com.google.dagger:hilt-compiler:2.46")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.activity:activity-ktx:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}