import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PersonModule_Companion_ProvidePersonFactory implements Factory<Person> {
  @Override
  public Person get() {
    return providePerson();
  }

  public static PersonModule_Companion_ProvidePersonFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Person providePerson() {
    return Preconditions.checkNotNullFromProvides(PersonModule.Companion.providePerson());
  }

  private static final class InstanceHolder {
    private static final PersonModule_Companion_ProvidePersonFactory INSTANCE = new PersonModule_Companion_ProvidePersonFactory();
  }
}
