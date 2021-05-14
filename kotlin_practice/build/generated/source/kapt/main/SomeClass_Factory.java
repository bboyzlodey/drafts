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
public final class SomeClass_Factory implements Factory<SomeClass> {
  private final Provider<Person> personProvider;

  public SomeClass_Factory(Provider<Person> personProvider) {
    this.personProvider = personProvider;
  }

  @Override
  public SomeClass get() {
    return newInstance(personProvider.get());
  }

  public static SomeClass_Factory create(Provider<Person> personProvider) {
    return new SomeClass_Factory(personProvider);
  }

  public static SomeClass newInstance(Person person) {
    return new SomeClass(person);
  }
}
