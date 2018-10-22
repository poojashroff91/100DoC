package prototype;

class Point
{
    public int x, y;

    public Point( int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point (Point other){
        this.x = other.x;
        this.y = other.y;
    }


}

class Line
{
    public Point start, end;

    public Line (Point start, Point end){
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        return new Line(new Point(this.start), new Point(this.end));
    }
}
