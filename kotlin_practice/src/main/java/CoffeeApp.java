

import dagger.Component;

import javax.inject.Singleton;

/** The main app responsible for brewing the coffee and printing the logs. */
public class CoffeeApp {
  @Singleton
  @Component(
      modules = {
        HeaterModule.class,
        PumpModule.class
      }
  )
  public interface CoffeeShop {
    CoffeeMaker maker();
    CoffeeLogger logger();
  }

  public static void main(String[] args) {
//    CoffeeShop coffeeShop = DaggerCoffeeApp_CoffeeShop.builder().build();
//    coffeeShop.maker().brew();
//    coffeeShop.logger().logs().forEach(log -> System.out.println(log));
  }
}
