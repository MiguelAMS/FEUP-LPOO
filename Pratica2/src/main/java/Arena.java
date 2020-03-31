import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        Position pos;
        for (int i = 0; i < 5; i++) {
            pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            if (!pos.equals(hero.getPosition()))
                coins.add(new Coin(pos.getX(), pos.getY()));
            else i--;
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        Position pos;
        for (int i = 0; i < 5; i++) {
            pos = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            if (!pos.equals(hero.getPosition()))
                monsters.add(new Monster(pos.getX(), pos.getY()));
            else i--;
        }
        return monsters;
    }

    private void retrieveCoins() {
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getPosition().equals(hero.getPosition())) {
                coins.remove(i);
                return;
            }
        }
    }

    public boolean verifyMonsterCollisions() throws InterruptedException {
        for(Monster monster: monsters){
            if(monster.getPosition().equals(hero.getPosition())) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Game Over!");
                return true;
            }
        }
        return false;
    }

    public boolean verifyCoinsLeft() throws InterruptedException {
        if (coins.isEmpty()) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("You Won!!!");
            return true;
        }
        return false;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#808080"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        for(Wall wall : walls){
            if(wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private void moveMonsters() {
        Position pos;
        for (Monster monster : monsters) {
            pos = monster.move();
            if (canHeroMove(pos))
                monster.setPosition(pos);
        }
    }

    public int processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case EOF: return 1;
        }
        retrieveCoins();
        moveMonsters();
        return 0;
    }
}
