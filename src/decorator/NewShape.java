package decorator;
import java.util.function.Supplier;
interface NewShape {
    String info();
}

class NewCircle implements NewShape {
    private float radius;

    public NewCircle(float radius) {
        this.radius = radius;
    }

    public NewCircle() {
    }

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "A circle of radius " + radius;
    }
}

class NewSquare implements NewShape {
    private float side;

    public NewSquare() {
    }


    public NewSquare(float side) {
        this.side = side;
    }

    @Override
    public String info() {
        return "A square of side size: " + side;
    }
}

class NewColoredShape <T extends NewShape> implements NewShape{

    private NewShape shape;
    private String color;

    public NewColoredShape(Supplier<? extends T> ctor, String color) {
        shape = ctor.get();
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has the color " + color;
    }
}

class NewTransparentShape <T extends NewShape> implements NewShape{

    private NewShape shape;
    private int transparency;

    public NewTransparentShape(Supplier<? extends T> ctor, int transparency) {
        shape = ctor.get();
        this.transparency = transparency;
    }

    @Override
    public String info() {
        return shape.info() + " has the transparency " + transparency;
    }
}

class DemoNewShape {
    public static void main(String[] args) {
        NewColoredShape<NewSquare> blueSquare = new NewColoredShape<>(
                ()-> new NewSquare(20),
                "blue"
        );
        System.out.println(blueSquare.info());

        NewTransparentShape<NewColoredShape> myCircle = new NewTransparentShape<>(
                () -> new NewColoredShape<>(
                        ()-> new NewCircle(20),
                        "green"
                ),
                50
        );
        System.out.println(myCircle.info());

    }
}

