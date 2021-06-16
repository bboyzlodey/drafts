package inAction

import inAction.PropertyChangeAware
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty(var propertyValue: Int, val changeSupport: PropertyChangeSupport) {
   operator fun getValue(person: Person, property: KProperty<*>): Int = propertyValue

    operator fun setValue(person: Person, property: KProperty<*>, newValue: Int) {
        val oldValue = propertyValue
        propertyValue = newValue
        changeSupport.firePropertyChange(property.name, oldValue, newValue)
    }
}