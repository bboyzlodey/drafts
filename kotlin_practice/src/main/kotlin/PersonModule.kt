import dagger.Module
import dagger.Provides

@Module
interface PersonModule {
    companion object {
        @Provides fun providePerson(): Person {
            return Person("Michael")
        }
    }
}