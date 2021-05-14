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
public final class Thermosiphon_Factory implements Factory<Thermosiphon> {
  private final Provider<CoffeeLogger> loggerProvider;

  private final Provider<Heater> heaterProvider;

  public Thermosiphon_Factory(Provider<CoffeeLogger> loggerProvider,
      Provider<Heater> heaterProvider) {
    this.loggerProvider = loggerProvider;
    this.heaterProvider = heaterProvider;
  }

  @Override
  public Thermosiphon get() {
    return newInstance(loggerProvider.get(), heaterProvider.get());
  }

  public static Thermosiphon_Factory create(Provider<CoffeeLogger> loggerProvider,
      Provider<Heater> heaterProvider) {
    return new Thermosiphon_Factory(loggerProvider, heaterProvider);
  }

  public static Thermosiphon newInstance(CoffeeLogger logger, Heater heater) {
    return new Thermosiphon(logger, heater);
  }
}
