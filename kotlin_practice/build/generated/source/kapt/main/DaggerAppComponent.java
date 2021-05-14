import dagger.internal.DaggerGenerated;
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
public final class DaggerAppComponent implements AppComponent {
  private DaggerAppComponent() {

  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  @Override
  public Cat getCat() {
    return new Cat(PersonModule_Companion_ProvidePersonFactory.providePerson());
  }

  @Override
  public SomeClass getSome() {
    return new SomeClass(PersonModule_Companion_ProvidePersonFactory.providePerson());
  }

  @Override
  public SomeClass2 getSome2() {
    return injectSomeClass2(SomeClass2_Factory.newInstance(getSome()));
  }

  private SomeClass2 injectSomeClass2(SomeClass2 instance) {
    SomeClass2_MembersInjector.injectSomeClass(instance, getSome());
    return instance;
  }

  public static final class Builder {
    private Builder() {
    }

    public AppComponent build() {
      return new DaggerAppComponent();
    }
  }
}
