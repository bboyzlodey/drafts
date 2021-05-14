import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class Cat1_Factory implements Factory<Cat1> {
  @Override
  public Cat1 get() {
    return newInstance();
  }

  public static Cat1_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Cat1 newInstance() {
    return new Cat1();
  }

  private static final class InstanceHolder {
    private static final Cat1_Factory INSTANCE = new Cat1_Factory();
  }
}
