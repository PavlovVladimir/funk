# funk
Small functional programming library written in Kotlin.

[https://jitpack.io/#PavlovVladimir/funk](https://jitpack.io/#PavlovVladimir/funk)

[![Release](https://jitpack.io/v/PavlovVladimir/funk.svg)](https://jitpack.io/#PavlovVladimir/funk)

To use it, add jitpack repository:
```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```
and to dependency:
```groovy
dependencies {
    ...
    implementation 'com.github.PavlovVladimir:funk:0.0.2+'
}
```
Examples:
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