package games.spaceinvaders;

import com.javarush.engine.cell.*;
import games.spaceinvaders.gameobjects.Bullet;
import games.spaceinvaders.gameobjects.EnemyFleet;
import games.spaceinvaders.gameobjects.PlayerShip;
import games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;



    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) createGame();
        if (key == Key.LEFT) playerShip.setDirection(Direction.LEFT);
        if (key == Key.RIGHT) playerShip.setDirection(Direction.RIGHT);
        if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(bullet);
            }
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT
                || key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        drawScene();
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x > 0 && y > 0 && x < WIDTH && y < HEIGHT) {
            super.setCellValueEx(x, y, cellColor, value);
        }
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