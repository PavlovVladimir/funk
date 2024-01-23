package com.github.pavlovvladimir

/** Optional type */
sealed class Optional<out T> {

    companion object {
        fun <T> empty(): Optional<T> = None

        fun <T> lift(value: T): Optional<T> = Some(value)
    }
}

data object None : Optional<Nothing>()
data class Some<T>(val value: T) : Optional<T>()

fun <T : Any?> T.opt(): Optional<T> = if (this == null) Optional.empty() else Optional.lift(this)

/** Extract the value in the Optional or default value */
fun <T> Optional<T>.getOrDefault(defaultValue: T): T = when (this) {
    is None -> defaultValue
    is Some<T> -> value
}

fun <T> Optional<T>.getOrDefault(defaultValue: () -> T): T = when (this) {
    is None -> defaultValue()
    is Some<T> -> value
}

fun <T> Optional<T>.getOrNull(): T? = getOrDefault(null)

fun <T> Optional<T>.orElse(defaultValue: Optional<T>): Optional<T> = when (this) {
    is None -> defaultValue
    is Some<T> -> this
}

fun <T> Optional<T>.orElse(defaultValue: () -> Optional<T>): Optional<T> = when (this) {
    is None -> defaultValue()
    is Some<T> -> this
}

fun <A> Optional<A>.filter(f: function<A, Boolean>): Optional<A> = when (this) {
    is None -> None
    is Some -> {
        if (f(value)) Optional.lift(value) else None
    }
}

fun <A, B> Optional<A>.map(f: function<A, B>): Optional<B> = when (this) {
    is None -> None
    is Some -> try {
        Some(f(value))
    } catch (e: Exception) {
        None
    }
}

fun <A, B> Optional<A>.flatMap(f: function<A, Optional<B>>): Optional<B> = when (this) {
    is None -> Optional.empty()
    is Some<A> -> {
        when (val opt = f(value)) {
            is None -> Optional.empty()
            is Some<B> -> Optional.lift(opt.value)
        }
    }
}

@Dirty("looks bad")
fun <A> Optional<A>.execute(f: function<A, Unit>) = when (this) {
    is None -> pass
    is Some -> f(value)
}

@Dirty("looks bad")
fun <A> Optional<A>.execute(f: function<A, Unit>, default: () -> Unit) = when (this) {
    is None -> default()
    is Some -> f(value)
}