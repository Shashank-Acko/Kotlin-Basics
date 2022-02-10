package com.example.kotlinbasics

import java.lang.IllegalArgumentException

fun main() {
    //TODO: Allows to add reference to this comment
    var name = "Test Name" //var can be changed while val is constant

    name = "New Name" //var is overwritten

    print("Hello" + name) //print("Hello${name}") : String interpolation

    //Data types:
    //Numbers: 8bit, 16bit, 32bit, 64bit
    var myByte: Byte = 13
    var myShort: Short = 125
    var myInt: Int = 123123123
    var myLong: Long = 12_123_123_123_123_123_12

    //Floating point: 32bit, 64bit
    var myFloat: Float = 32.3F
    var myDouble: Double = 3.12451512412

    //Boolean: 1bit
    var check: Boolean = true //No explicit need to declare boolean, assigning true will make it so

    //Characters: 4bit
    var letter = 'A'

    //Strings:
    val msg = "String is connection of chars"
    var firstLetter = msg[0] //S

    //Arithmetic Operator
    var result = 5
    val a = 5.0
    val b = 3
    var resultDouble: Double

    resultDouble = (a/b)

    //Comparison Operators: (==, !=, <, >, <=, >=) AND Assignment Operators: (+=, -=, *=, /=, %=)
    //Increment and Decrement Operators: --, ++ {Post and Pre}

    //Conditionals: if, else if, else -> Similar to c++

    //Switch case in kotlin:
    var month = 3

    when(month) {
        in 2..5 -> println("Spring")
        in 6..8 -> println("Summer")
        in 9..11 -> println("Fall")
        12, 1, 2 -> println("Winter") //We can also do !in 1..12 for else part
        else -> {
            println("Invalid")
        }
    }

    //While, do while loop is similar to C++

    //For loop

    for(i in 1..2) {
        for(i in 1 until 3) {
            for(i in 6 downTo 1 step 2) { //Similar to: for(i in 10.downTo(1).step(2))
                //Do some operations
                //Can be used with break and continue
            }
        }
    }

    //Nullable:
    var isNullable: String? = null //non null types cannot be assigned to null later
    isNullable = "name"

    //To check length of isNullable, either check if it is null or not OR
    var length = isNullable?.length

    //Elvis operator
    val temp = isNullable ?: "Default value"

    //Not null assertion: Assumes that given value is not null otherwise compilation error
    isNullable!!.lowercase()

    //Safe chaining: val wifeAge: String? = user?.wife?.age ?: 0

    //Copying an object from a class
    val user1 = User(id=1, name="Test name")
    val updatedUser = user1.copy(name="First last")

    println(updatedUser.component1())
    println(updatedUser.component2())

    val (id, Name) = updatedUser
}

//Functions:
fun add(a: Int, b: Int) : Int {
    return a + b
}

//Object Oriented Programming

class Person constructor(firstName: String = "First", lastName: String = "Last") {
    //Member variables - Properties
    var firstName: String ?= null //{can be used with typecasting as well}
    var lastName: String ?= null
    var age: Int? = null
    var hobby: String = "Random hobby"

    //Use lateinit if initializing variables later
    //lateinit var temp: String

    var test: Int = 1
    //Custom getter
//    get() {
//        return field.lowercase()
//    }
    //Custom setter
    set(value) {
        field = if(value > 0) value else throw IllegalArgumentException("Max speed cannot be negative")
    }

    var pvtVariable: String = "test string 2"
    private set //Won't allow setting of variable outside the class but can be accessed as getter is public

    //Initializer Block
    init {
        this.firstName = firstName
        this.lastName = lastName
        println("Name is $firstName $lastName")
    }

    //Member secondary constructor
    constructor(firstName: String, lastName: String, age: Int)
            :this(firstName, lastName) {
        this.age = age
    }

    //Member functions: Methods

    fun stateHobby() {
        println("My hobby is $hobby")
    }
}

//Data class

data class User(val id: Long, var name: String)
//Must have at least one parameter and cannot be abstract, open, sealed or inner classes

//Inheritance

open class Parent(val name:String) {
    //Properties
    open var temp: String = "Test variable"

    //Methods

    open fun test() {
        println("This is created in parent class")
    }
}

class Child(name:String) : Parent(name) {
    override var temp: String = "Changed temp value"

    override fun test() {
        println("This function overrides fun in parent class") //Polymorphism
    }
}

//Interfaces: are contracts that a class may choose to sign, if it does, then it has to provide the implementation.

interface IntFace {
    //Properties
    var name: String

    //Methods
    fun define(): String
}

//super.method() calls the parent definition of a method, eg.

/*override fun define() {
    super.define()
    println("Line is implemented with overload")
}*/

//Abstract classes cannot have objects but are used to inherit into other classes, can store states

//Collection can be of single type or multiple types:

val num:IntArray = intArrayOf(1, 2, 3) //we can remove IntArray, and also int and use arrayOf(1,2,3)

//print(num.contentToString()) for printing elements else it will give the address of the array

//We can have random access using index and also loop over the array

//Apart from IntArrayOf, we have doubleArrayOf, array of objects

//listOf is list implementation of array & mutableListOf<Type>(elements), set contains unique elements and arrayList
//is vector from C++

val sum: (Int, Int) -> Int = {a:Int, b:Int -> a + b} //lambda expression
val sumShort = {a:Int, b:Int -> println(a+b)} //non returning statement

//Visibility modifiers: public, private, protected, internal & inner class can access the outer class.

//Exceptions: try, catch, finally, throw

/* try {
       //code
   }
   catch(e: Exception) {
       //exception
   }
   finally {
       //always executes
   }

   throw(Exception) is used to manually throw the exception
*/

//************_____THE END______*************