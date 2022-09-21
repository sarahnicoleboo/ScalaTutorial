package scala_tutorial

import org.scalatest.funsuite.AnyFunSuite

class SimpleTest extends AnyFunSuite {
	test("simplest test possible") {
		assert("Scala".toLowerCase == "scala")
	}
}