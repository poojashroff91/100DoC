package bridge;

interface Renderer2 {
}

class VectorRenderer2 implements Renderer2 {

    @Override
    public String toString() {
        return "Drawing %s as lines";
    }
}

class RasterRenderer2 implements Renderer2 {
    @Override
    public String toString() {
        return "Drawing %s as pixels";
    }
}

abstract class Shape2

{
    protected Renderer2 renderer;

    public Shape2(Renderer2 renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();
}

class Triangle extends Shape2
{
    @Override
    public String getName()
    {
        return "Triangle";
    }

    public Triangle(Renderer2 renderer) {
        super(renderer);
    }
    @Override
    public String toString() {
        return String.format(renderer.toString(), getName());
    }

}

class Square extends Shape2

{
    public Square(Renderer2 renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format(renderer.toString(), getName());
    }
}


class DemoShape2 {
    public static void main(String[] args) {
        System.out.println(new Triangle(new RasterRenderer2()).toString());
    }
}