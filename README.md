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
example:
```kotlin
"Hello world!" pipe ::println // print Hello world! in terminal
```
- ```fun cat```
  (works like cat in *nix systems)
```kotlin
::<fun> cat <smth>
```
example:
```kotlin
::println cat "Hello world!"// print Hello world! in terminal
```
- ```fun compose```
  Let's assume we have 3 functions:
```kotlin
private fun intToString(n: Int): String = n.toString()
private fun stringToInt(s: String): Int = s.length
private fun add10(n: Int): Int = n + 10
```
```kotlin
val s = intToString(100) // "100"
val k = stringToInt(s) // 3
val n = add10(k) // 13
```
The usual way looks like:
```kotlin
val n:Int = add10(stringToInt(intToString(100))) // 13
```
The FP way looks like:
```kotlin
val f:Int = ::intToString compose ::stringToInt compose ::add10 // f here is function (n: Int) -> Int 
val n = f(100) // 13
```
Looks more readable, right?

- ```fun after```
works similar way, but in another direction (look CompositionKtTest in test package)