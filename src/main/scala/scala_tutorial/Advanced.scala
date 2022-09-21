package scala_tutorial

import scala.util.{Failure, Success, Try}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

	/*
		lazy evaluation
	*/
	lazy val aLazyValue = 2
	lazy val lazyValueWithSideEffect = {
		println("I am so very lazy!")
		43
	}
	
	val eagerValue = lazyValueWithSideEffect + 1
	//useful in infinite collections
	
	
	/*
		"psuedo-collections": Option, Try
	*/
	def methodWhichCanReturnNull(): String = "hello, Scala"
	val anOption  = Option(methodWhichCanReturnNull())	//Some("hello, Scala")
	//option = "collection" which contains at most one element: Some(value) or None
	
	val stringProcessing = anOption match {
		case Some(string) => s"I have obtained a valid string: $string"
		case None => "I obtained nothing"
	}
	
	def methodWhichCanThrowException(): String = throw new RuntimeException
	val aTry = Try(methodWhichCanThrowException())
	//a try = "collection" which either has a value if the code went well or an exception if the code threw one
	
	val anotherStringProcessing = aTry match {
		case Success(validValue) => s"I have obtained a valid string: $validValue"
		case Failure(ex) => s"I have obtained an exception: $ex"
	}
	// map, flatMap, filter can also be used on Option and Try
	
	
	/*
		Evalute something on another thread
		(asynchronous programming)
	*/
	val aFuture = Future({	//Future.apply() so we usually OMIT the parenthesis here
		println("Loading...")
		Thread.sleep(1000)
		println("I have computed a value")
		67
	})
	
	Thread.sleep(2000) 	//this will make the main thread sleep so Future has time to evaluate
	
	//future is a "collection" which contains a value when it's evaluated
	//future is composable with map, flatMap and filter
	//these things are actually monads
	
	
	/*
		Implicits basics
	*/
	//#1: implicit arguments
/* 	def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
	implicit val myImplicitInt = 46
	println(aMethodWithImplicitArgs)	//aMethodWithImplicitArgs(myImplicitInt) */
	//this is apparently for scala 2 and needs to change for scala 3 but I don't want to research it since not important rn
	
	//#2: implicit conversions
	implicit class MyRichInteger(n: Int) {
		def isEven() = n % 2 == 0
	}
	println(23.isEven())	//new MyRichInteger(23).isEven()
	//use this carefully
	
}