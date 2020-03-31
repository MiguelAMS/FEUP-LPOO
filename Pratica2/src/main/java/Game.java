import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    private Screen screen = new TerminalScreen(terminal);
    private Arena arena = new Arena(53, 24); // 80 _ 24
    private TextGraphics graphics = screen.newTextGraphics();

    Game() throws IOException {
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    private int processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
            return 0;
        }
        return arena.processKey(key);
    }

    public void run() throws IOException, InterruptedException {
        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (processKey(key) == 1) break;
            if (arena.verifyMonsterCollisions()) {
                screen.close();
                break;
            }
            if (arena.verifyCoinsLeft()) {
                screen.close();
                break;
            }
        }
    }
}
