import dagger.internal.DaggerGenerated
import javax.inject.Inject

fun main(args: Array<String>) {
    println("Hello World!")
    println(DaggerAppComponent.create().getCat().person.name)
    DaggerCoffeeApp_CoffeeShop.create().maker().brew()
    println( DaggerCoffeeApp_CoffeeShop.create().logger().logs())
    println("SomeClass " + DaggerAppComponent.create().getSome().person.name)
//    println("SomeClass2 " + DaggerAppComponent.create().getSome2().someClass.name)
    println("SomeClass2 " + DaggerAppComponent.create().getSome2())

}

class SomeClass @Inject constructor(val person: Person) {

}

class SomeClass2 @Inject constructor(val someClass2: SomeClass) {
    @Inject lateinit var someClass: SomeClass

    /*init {
        DaggerAppComponent.create().inject(this)
    }*/
}