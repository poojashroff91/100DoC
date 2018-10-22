package adapter;

import java.util.*;
import java.util.function.Consumer;

public class Point {
    public int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Line {
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) &&
                Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

class VectorObject extends ArrayList<Line>{

}

class VectorRectangle extends VectorObject{

    public VectorRectangle(int x, int y, int width, int height) {
        add(new Line(new Point(x,y), new Point(x + width, y)));
        add(new Line(new Point(x + width,y), new Point(x + width, y + height)));
        add(new Line(new Point(x,y), new Point(x, y + height)));
        add(new Line(new Point(x,y + height), new Point(x + width, y + height)));

    }
}

class LineToPointAdapter implements Iterable<Point>{
    @Override
    public Iterator<Point> iterator() {
        return cache.get(hash).iterator();
    }

    @Override
    public void forEach(Consumer<? super Point> action) {
        cache.get(hash).forEach(action);
    }

    @Override
    public Spliterator<Point> spliterator() {
        return cache.get(hash).spliterator();
    }

    private static int count = 0;
    private static Map<Integer, List<Point>> cache = new HashMap<>();
    private int hash;

    public LineToPointAdapter(Line line){

        hash = line.hashCode();
        if(cache.get(hash) != null) return;

        System.out.println(String.format(
                "%d: Generating points for line [%d,%d]-[%d,%d] (with caching)",
                ++count, line.start.x, line.start.y, line.end.x, line.end.y
        ));

        ArrayList<Point> points = new ArrayList<>();

        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.y, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0) {
            for (int i = top; i <= bottom ; ++i) {
                points.add(new Point(left, i));
            }
        } else if (dy == 0) {
            for (int j = left; j <= right ; ++j) {
                points.add(new Point(j, top));
            }

        }

        cache.put(hash, points);

    }
}

class DemoLine {
    private final static List<VectorObject> vectorObjects = new ArrayList<>(Arrays.asList(
            new VectorRectangle(1,1,10,10),
            new VectorRectangle(3,3,6,6)
    ));

    //Convert VectorObject to Point
    public static void drawPoint(Point p) {
        System.out.println(".");
    }

    private static void draw(){
        for (VectorObject vo : vectorObjects) {
            for (Line line: vo) {
                LineToPointAdapter adapter = new LineToPointAdapter(line);
                adapter.forEach(DemoLine::drawPoint);
            }
        }
    }

    public static void main(String[] args) {
        draw();
        draw();
    }
}
