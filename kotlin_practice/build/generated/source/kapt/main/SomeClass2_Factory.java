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
public final class SomeClass2_Factory implements Factory<SomeClass2> {
  private final Provider<SomeClass> someClass2Provider;

  private final Provider<SomeClass> someClassProvider;

  public SomeClass2_Factory(Provider<SomeClass> someClass2Provider,
      Provider<SomeClass> someClassProvider) {
    this.someClass2Provider = someClass2Provider;
    this.someClassProvider = someClassProvider;
  }

  @Override
  public SomeClass2 get() {
    SomeClass2 instance = newInstance(someClass2Provider.get());
    SomeClass2_MembersInjector.injectSomeClass(instance, someClassProvider.get());
    return instance;
  }

  public static SomeClass2_Factory create(Provider<SomeClass> someClass2Provider,
      Provider<SomeClass> someClassProvider) {
    return new SomeClass2_Factory(someClass2Provider, someClassProvider);
  }

  public static SomeClass2 newInstance(SomeClass someClass2) {
    return new SomeClass2(someClass2);
  }
}
