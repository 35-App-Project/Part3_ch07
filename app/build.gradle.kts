plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.choi.part3_ch07"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.choi.part3_ch07"
        minSdk = 23
        targetSdk = 34
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

    buildFeatures {
      dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // ViewModel 편하게 사용 하기 위함
    implementation("androidx.activity:activity-ktx:1.8.2")

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-compiler:2.48.1")

    // Room DB
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    /*
     gradle 에 이것을 추가 했더니 DB 가 생성되지 않았다
     kapt("androidx.room:room-compiler-processing:2.6.1")
     */
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

}

kapt {
    correctErrorTypes=true
}