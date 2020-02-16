package games.spaceinvaders;

import com.javarush.engine.cell.*;
import games.spaceinvaders.gameobjects.EnemyFleet;
import games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        drawScene();
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
    }

    private void drawField() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setCellValueEx(i, j, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(Math.random() * WIDTH, Math.random() * HEIGHT));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
    }
}