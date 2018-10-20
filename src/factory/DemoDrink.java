package factory;

import javafx.util.Pair;
import java.util.*;

interface HotDrink {
    void consume();
}

class Tea implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This tea is delicious");
    }
}

class Coffee implements HotDrink{
    @Override
    public void consume() {
        System.out.println("This coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink prepare(int amount);
}

class TeaFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Put in tea bag, boil water, pour " + amount +
                "ml, add lemon, enjoy!");
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory{
    @Override
    public HotDrink prepare(int amount) {
        System.out.println("Grind some beans, boil water, pour " + amount +
                "ml, add cream and sugar, enjoy!");
        return new Coffee();
    }

}
class HotDrinkMachine{

    public enum AvailableDrink {
        COFFEE, TEA
    }

    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();
    private Dictionary<AvailableDrink, HotDrinkFactory> factories = new Hashtable<>();

    public HotDrinkMachine() throws Exception {

        for (AvailableDrink drink: AvailableDrink.values()){
            String s = drink.toString();
            String factoryName = "" + Character.toUpperCase(s.charAt(0))+ s.substring(1).toLowerCase();
            Class<?> factory = Class.forName("factory." + factoryName + "Factory");
            factories.put(drink, (HotDrinkFactory) factory.getDeclaredConstructor().newInstance());

        }

    }

    public HotDrink makeDrink(AvailableDrink drink, int amount){
        return factories.get(drink).prepare(amount);
    }
}

public class DemoDrink {

    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink(HotDrinkMachine.AvailableDrink.TEA, 200);
        drink.consume();
    }
}
