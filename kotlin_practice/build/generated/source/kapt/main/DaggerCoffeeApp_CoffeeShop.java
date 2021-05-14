import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
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
public final class DaggerCoffeeApp_CoffeeShop implements CoffeeApp.CoffeeShop {
  private Provider<CoffeeLogger> coffeeLoggerProvider;

  private Provider<ElectricHeater> electricHeaterProvider;

  private Provider<Heater> bindHeaterProvider;

  private DaggerCoffeeApp_CoffeeShop() {

    initialize();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static CoffeeApp.CoffeeShop create() {
    return new Builder().build();
  }

  private Thermosiphon thermosiphon() {
    return new Thermosiphon(coffeeLoggerProvider.get(), bindHeaterProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize() {
    this.coffeeLoggerProvider = DoubleCheck.provider(CoffeeLogger_Factory.create());
    this.electricHeaterProvider = ElectricHeater_Factory.create(coffeeLoggerProvider);
    this.bindHeaterProvider = DoubleCheck.provider((Provider) electricHeaterProvider);
  }

  @Override
  public CoffeeMaker maker() {
    return new CoffeeMaker(coffeeLoggerProvider.get(), DoubleCheck.lazy(bindHeaterProvider), thermosiphon());
  }

  @Override
  public CoffeeLogger logger() {
    return coffeeLoggerProvider.get();
  }

  public static final class Builder {
    private Builder() {
    }

    public CoffeeApp.CoffeeShop build() {
      return new DaggerCoffeeApp_CoffeeShop();
    }
  }
}
