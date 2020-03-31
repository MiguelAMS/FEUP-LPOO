public class Position {
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() { return y; }
    public int getX() { return x; }

    public boolean equals(Position pos) {
        return this.getX() == pos.getX() && this.getY() == pos.getY();
    }
}
