object Versions{
    // Kotlin
    const val KOTLIN_VERSION = "1.6.10"

    // AndroidX
    const val APP_COMPAT = "1.3.1"
    const val MATERIAL = "1.4.0"
    const val CONSTRAINT_LAYOUT = "2.1.0"

    const val ACTIVITY_KTX = "1.6.0"
    const val FRAGMENT_KTX = "1.5.3"
    const val LIFECYCLE_KTX = "2.5.1"
    const val ROOM = "2.4.3"

    const val HILT = "2.38.1"

    // KTX
    const val CORE_KTX = "1.6.0"

    // TEST
    const val JUNIT = "4.+"
    const val ANDROID_JUNIT = "1.1.3"

    // Android Test
    const val ESPRESSO_CORE = "3.4.0"

    // Coroutine
    const val KOTLINX_COROUTINES = "1.6.1"

    // Navigation
    const val NAVIGATION = "2.4.1"
}

object Kotlin{
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINES_CORE    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
}

object AndroidX {
    const val CORE_KTX                = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT              = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT       = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    const val ACTIVITY_KTX            = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX            = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX  = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"

    const val ROOM_RUNTIME            = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX                = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER           = "androidx.room:room-compiler:${Versions.ROOM}"
    const val NAVIGATION_RUNTIME      = "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_FRAGMENT     = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI           = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
}

object Google {
    const val HILT_ANDROID          = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
}

object Test {
    const val JUNIT         = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}