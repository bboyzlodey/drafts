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
public final class CoffeeLogger_Factory implements Factory<CoffeeLogger> {
  @Override
  public CoffeeLogger get() {
    return newInstance();
  }

  public static CoffeeLogger_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CoffeeLogger newInstance() {
    return new CoffeeLogger();
  }

  private static final class InstanceHolder {
    private static final CoffeeLogger_Factory INSTANCE = new CoffeeLogger_Factory();
  }
}
