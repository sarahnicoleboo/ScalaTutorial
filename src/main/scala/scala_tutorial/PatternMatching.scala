package scala_tutorial

object PatternMatching extends App {

	//switch expression
	val anInteger = 55
	val order = anInteger match {
		case 1 => "first"
		case 2 => "second"
		case 3 => "third"
		//case _ => anInteger + "th"	//this is also giving a deprecation warning that we cannot add ints to strings now
									//should be replaced with sInterpolated String
		case _ => s"$anInteger th"
	}
	// PM is an EXPRESSION
	
	//Case class decompisition
	case class Person(name: String, age: Int)
	val bob = Person("Bob", 43)	//Person.apply("Bob", 43)
	
	val personGreeting = bob match {
		case Person(n, a) => s"Hi, my name is $n and I am $a years old."
		//case _ => "Something else"	//These are giving compilation errors because they are essentially unreachable
									//Should be replaced by null => "Something else
		case null => "Something else"
	}
	
	//deconstructing tuples
	val aTuple = ("Bon Jovi", "Rock")
	val bandDescription = aTuple match {
		case (band, genre) => s"$band belongs to the genre $genre"
		//case _ => "I don't know what you're talking about"	//same comment as above
		case null => "Something else"
	}
	
	//decomposing lists
	val aList = List(1,2,3)
	val listDescription = aList match {
		case List(_,2,_) => "List containing 2 on its second position"
		case _ => "uknown list"
	}
	
	//if PM doesn't match anything, it will throw a MatchError
	//PM will try all cases in sequence (in order as written)
}