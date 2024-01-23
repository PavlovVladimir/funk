package com.github.pavlovvladimir

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class OptionalTest : WordSpec({

    val none = Optional.empty<Int>()

    val some = Some(10)

    "opt() function" should {
        "get Some if object is not null" {
            1.opt() shouldBe Some(1)
            "hello".opt() shouldBe Some("hello")
        }
        "get None if object is null" {
            val a: Any? = null
            a.opt() shouldBe None
        }
    }

    "optional map" should {
        "transform Some<Int>(10) to Some<Int>(30)" {
            some.map { it * 3 } shouldBe Some(30)
        }
        """transform Some<Int>(10) to Some<String>("10")""" {
            some.map { it.toString() } shouldBe Some("10")
        }
        "none map to none" {
            none.map { it * 100 } shouldBe None
        }
    }

    "optional flatMap" should {
        """Some<Int> to Some<Int>""" {
            some.flatMap { a -> Some(a.toString().length) } shouldBe Some(2)
        }
        "none map to none" {
            none.flatMap { a -> Some(a.toString()) } shouldBe None
        }
    }

    "optional getOrDefault" should {
        "extract the value of optional some" {
            some.getOrDefault(0) shouldBe 10
        }
        "return a default value if the optional is none" {
            none.getOrDefault(10) shouldBe 10
        }
    }

    "optional getOrDefault_2" should {
        "extract the value of optional some" {
            some.getOrDefault { 0 } shouldBe 10
        }
        "return a default value if the optional is none" {
            none.getOrDefault { 10 } shouldBe 10
        }
        "return a def value if the optional is none" {
            none.getOrDefault { "hello" } shouldBe "hello"
        }
    }

    "optional getOrNull" should {
        "extract the value of optional some" {
            some.getOrNull() shouldBe 10
        }
        "return a null if the optional is none" {
            none.getOrNull() shouldBe null
        }
    }

    "optional orElse" should {
        "return optional if the optional is some" {
            some.orElse(Some(100)) shouldBe Some(10)
        }
        "if optional is none, return default optional" {
            none.orElse(Some(100)) shouldBe Some(100)
        }
    }

    "optional orElse2" should {
        "return optional if the optional is some" {
            some.orElse { Some(100) } shouldBe Some(10)
        }
        "if optional is none, return default optional" {
            none.orElse { Some(100) } shouldBe Some(100)
        }
    }

    "optional filter" should {
        "if predicate is true, return some" {
            some.filter { it > 0 } shouldBe some
        }
        "if predicate is false, return none" {
            some.filter { it < 0 } shouldBe None
        }
    }

    "optional execute" should {
        "execute if optional is some" {
            var a = ""
            some.execute { a = it.toString() }
            a shouldBe ("10")
        }
        "do nothing if the optional is none" {
            var a = ""
            none.execute { a = it.toString() }
            a shouldBe ("")
        }
    }

    "optional execute with default action" should {
        "execute if optional is some" {
            var a = ""
            some.execute({ a = it.toString() }, { a = "none" })
            a shouldBe ("10")
        }
        "do nothing if the optional is none" {
            var a = ""
            none.execute({ a = it.toString() }, { a = "none" })
            a shouldBe ("none")
        }
    }
})