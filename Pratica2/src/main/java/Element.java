import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;

    Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public abstract void draw(TextGraphics graphics);

    public void setPosition(Position position) { this.position = position; }
    public Position getPosition() { return position; }

    public int getY() {
        return position.getY();
    }
    public int getX() {
        return position.getX();
    }

}
