package adapter;

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    private Square square;
    public SquareToRectangleAdapter(Square square)
    {
        // todo
        this.square = square;
    }

    @Override
    public int getWidth() {
        return square.getSide();
    }

    @Override
    public int getHeight() {
        return square.getSide();
    }
}