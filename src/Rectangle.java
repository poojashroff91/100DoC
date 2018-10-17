import org.w3c.dom.css.Rect;

import java.util.Iterator;

public class Rectangle {

    private int height;
    private int width;


    public Rectangle() {
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }

    public boolean isSquare(){
        return width == height;
    }
}

class Square extends Rectangle {

    public Square() {
    }

    public Square(int size) {
       super.setHeight(size);
       super.setWidth(size);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}


class RectangleFactory {
    public static Rectangle newRectangle (int width, int height) {
        return new Rectangle(height, width);
    }

    public static Rectangle newSquare (int side) {
        return new Rectangle(side, side);
    }

}

class DemoRectangle {

    static void useIt (Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println(
                "Expect area of: " + (width * 10) +
                        ", got " + r.getArea()
        );
    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(2,3);
        useIt(rectangle);

        Square square = new Square();
        square.setWidth(4);
        useIt(square);


    }


}
