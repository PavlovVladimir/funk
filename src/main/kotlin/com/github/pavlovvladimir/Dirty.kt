package com.github.pavlovvladimir

@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class Dirty(val message: String)