package com.github.pavlovvladimir


/** Push value into function like | in *nix systems */
infix fun <A, B> A.pipe(f: function<A, B>): B = f(this)

/** Push value into function from right like cat in *nix systems */
infix fun <A, B> function<A, B>.cat(a: A): B = this(a)