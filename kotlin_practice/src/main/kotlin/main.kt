import dagger.internal.DaggerGenerated
import java.beans.PropertyChangeListener
import javax.inject.Inject

fun main(args: Array<String>) {
    launchPropertyChanged()
}

private fun launchDagger() {
    println(DaggerAppComponent.create().getCat().person.name)
    DaggerCoffeeApp_CoffeeShop.create().maker().brew()
    println(DaggerCoffeeApp_CoffeeShop.create().logger().logs())
    println("SomeClass " + DaggerAppComponent.create().getSome().person.name)
//    println("SomeClass2 " + DaggerAppComponent.create().getSome2().someClass.name)
    println("SomeClass2 " + DaggerAppComponent.create().getSome2())
}

class SomeClass @Inject constructor(val person: Person) {
}


class SomeClass2 @Inject constructor(val someClass2: SomeClass) {
    @Inject
    lateinit var someClass: SomeClass
    /*init {
        DaggerAppComponent.create().inject(this)
    }*/

}

private fun launchDecorator() {
    val textView = TextViewComponent()
    val scrollDecorator = ScrollDecorator(textView)
    val borderDecorator = BorderDecorator(scrollDecorator)
    borderDecorator.draw()
}

private fun launchPropertyChanged() {
    val person = inAction.Person(18, 3000)
    person.addPropertyChangedListener(PropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    })
    person.age++
    person.age += 10
    person.salary -= person.salary / 2
}
