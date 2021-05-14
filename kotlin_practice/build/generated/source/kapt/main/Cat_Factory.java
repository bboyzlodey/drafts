import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Cat_Factory implements Factory<Cat> {
  private final Provider<Person> personProvider;

  public Cat_Factory(Provider<Person> personProvider) {
    this.personProvider = personProvider;
  }

  @Override
  public Cat get() {
    return newInstance(personProvider.get());
  }

  public static Cat_Factory create(Provider<Person> personProvider) {
    return new Cat_Factory(personProvider);
  }

  public static Cat newInstance(Person person) {
    return new Cat(person);
  }
}
