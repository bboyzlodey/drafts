import dagger.Component

@Component(modules = [PersonModule::class])
interface AppComponent {
    fun getCat() : Cat
    fun getSome() : SomeClass
    fun getSome2() : SomeClass2
//    fun inject(someClass2: SomeClass2)
}