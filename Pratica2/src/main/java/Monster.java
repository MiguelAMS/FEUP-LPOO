import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    Monster(int x, int y) { super(x, y); }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(super.getX(), super.getY()), "M");
    }

    public Position move() {
        Position pos = new Position(super.getX(), super.getY());

        Random random = new Random();
        int rand = random.nextInt(8) + 1;

        switch (rand) {
            case 1: //Direita
                return new Position(super.getX() + 1, super.getY());
            case 2: //Esquerda
                return new Position(super.getX() - 1, super.getY());
            case 3: //Cima
                return new Position(super.getX(), super.getY() - 1);
            case 4: //Baixo
                return new Position(super.getX(), super.getY() + 1);
            case 5: //Cima Esquerda
                return new Position(super.getX() - 1, super.getY() - 1);
            case 6: //Cima Direita
                return new Position(super.getX() + 1, super.getY() - 1);
            case 7: //Baixo Esquerda
                return new Position(super.getX() - 1, super.getY() + 1);
            case 8: //Baixo Direita
                return new Position(super.getX() + 1, super.getY() + 1);
        }
        return pos;
    }
}
