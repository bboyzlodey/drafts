package inAction

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangedListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangedListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = { property: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(
            property.name,
            oldValue,
            newValue
        )
    }
    var age: Int by Delegates.observable(age, observer)

    var salary: Int by Delegates.observable(salary, observer)
}