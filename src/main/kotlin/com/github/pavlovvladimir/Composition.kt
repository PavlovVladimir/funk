package com.github.pavlovvladimir

inline infix fun <A, B, C> function<B, C>.after(crossinline f: function<A, B>): function<A, C> = { a: A ->
    this(f(a))
}

/** Compose two functions */
inline infix fun <A, B, C> function<A, B>.compose(crossinline g: function<B, C>): function<A, C> = { a: A ->
    g(this(a))
}