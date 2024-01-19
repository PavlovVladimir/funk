# funk
Funk is a small library for Functional Programming in Kotlin.

[https://jitpack.io/#PavlovVladimir/funk](https://jitpack.io/#PavlovVladimir/funk)

[![Release](https://jitpack.io/v/PavlovVladimir/funk.svg)](https://jitpack.io/#PavlovVladimir/funk)
[![Kotlin version](https://img.shields.io/badge/Kotlin-1.9.21-blue)](https://kotlinlang.org/docs/whatsnew1920.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

## Setup:
- add jitpack repository in root build.gradle:
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```
- add to dependency in module:
```groovy
dependencies {
    ...
    implementation 'com.github.PavlovVladimir:funk:0.0.2+'
}
```

## Examples:
- ```fun pipe```
  (works like pipes in *nix systems)
```kotlin
<smth> pipe ::<fun>
```
examples:
```kotlin
"Hello world!" pipe ::println // print Hello world! in terminal
```
- ```fun cat```
  (works like cat in *nix systems)
```kotlin
::<fun> cat <smth>
```
examples:
```kotlin
::println cat "Hello world!"// print Hello world! in terminal
```