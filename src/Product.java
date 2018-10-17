import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color {
    RED, GREEN, BLUE
}

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

public class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter( p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter( p -> p.size == size);
    }

    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size){
        return products.stream().filter( p -> p.size == size && p.color == color);
    }
}

class BetterFilter implements  Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p->spec.isSatisfied((p)));
    }
}

interface Specification<T> {
    boolean isSatisfied(T item);
}


interface Filter<T> {
   Stream<T> filter (List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{

    private Color color;

    public ColorSpecification( Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpecification implements Specification<Product>{

    private Size size;

    public SizeSpecification( Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class AndSpecification<T> implements Specification<T> {

    private Specification<T> first;
    private Specification<T> second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class DemoProduct {
    public static void main (String [] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List <Product> products = Arrays.asList(apple, tree, house);
        ProductFilter filter = new ProductFilter();
        System.out.println("Green products (old): ");
        filter.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green."));

        ColorSpecification colorSpecification = new ColorSpecification(Color.GREEN);
        SizeSpecification sizeSpecification = new SizeSpecification(Size.LARGE);

        BetterFilter betterFilter = new BetterFilter();
        System.out.println("Green products (new): ");
        betterFilter.filter(products, colorSpecification).forEach(p -> System.out.println(" - " + p.name + " is green."));

        System.out.println("Small items: ");
        betterFilter.filter(products, sizeSpecification).forEach(p -> System.out.println(" - " + p.name + " is small."));

        System.out.println("Large blue items: ");
        betterFilter.filter(products, new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE))).forEach(p -> System.out.println(" - " + p.name + " is blue and large."));


    }
}