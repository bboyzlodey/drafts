
abstract class ViewComponent{
    abstract fun draw()
}

class TextViewComponent: ViewComponent() {
    override fun draw() {
        println("TextViewComponent.draw")
    }
}

abstract class Decorator(private val component: ViewComponent) : ViewComponent() {
    override fun draw() {
        println("Decorator.draw")
        component.draw()
    }
}

class ScrollDecorator(component: ViewComponent) : Decorator(component) {
    override fun draw() {
        println("ScrollDecorator.draw")
        super.draw()
    }
}

class BorderDecorator(component: ViewComponent) : Decorator(component) {
    override fun draw() {
        println("BorderDecorator.draw")
        super.draw()
    }
}