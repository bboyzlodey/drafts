import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class SomeClass2_MembersInjector implements MembersInjector<SomeClass2> {
  private final Provider<SomeClass> someClassProvider;

  public SomeClass2_MembersInjector(Provider<SomeClass> someClassProvider) {
    this.someClassProvider = someClassProvider;
  }

  public static MembersInjector<SomeClass2> create(Provider<SomeClass> someClassProvider) {
    return new SomeClass2_MembersInjector(someClassProvider);
  }

  @Override
  public void injectMembers(SomeClass2 instance) {
    injectSomeClass(instance, someClassProvider.get());
  }

  @InjectedFieldSignature("SomeClass2.someClass")
  public static void injectSomeClass(SomeClass2 instance, SomeClass someClass) {
    instance.someClass = someClass;
  }
}
