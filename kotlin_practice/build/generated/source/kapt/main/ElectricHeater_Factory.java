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
public final class ElectricHeater_Factory implements Factory<ElectricHeater> {
  private final Provider<CoffeeLogger> loggerProvider;

  public ElectricHeater_Factory(Provider<CoffeeLogger> loggerProvider) {
    this.loggerProvider = loggerProvider;
  }

  @Override
  public ElectricHeater get() {
    return newInstance(loggerProvider.get());
  }

  public static ElectricHeater_Factory create(Provider<CoffeeLogger> loggerProvider) {
    return new ElectricHeater_Factory(loggerProvider);
  }

  public static ElectricHeater newInstance(CoffeeLogger logger) {
    return new ElectricHeater(logger);
  }
}
