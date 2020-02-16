package games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;
import games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {

    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<EnemyShip>();

        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }

    public void draw(Game game) {
        ships.forEach(enemyShip -> { enemyShip.draw(game); });
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0) return null;
        int shotProbability = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (shotProbability > 0) return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    private double getLeftBorder() {
        final double[] minX = {ships.get(0).x};
        ships.forEach(enemyShip -> {
            if (enemyShip.x < minX[0]) minX[0] = enemyShip.x;
        });
        return minX[0];
    }

    private double getRightBorder() {
        final double[] maxX = {ships.get(0).x};
        ships.forEach(enemyShip -> {
            double rightBorder = enemyShip.x + enemyShip.width;
            if (rightBorder > maxX[0]) maxX[0] = rightBorder;
        });
        return maxX[0];
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        if (ships.size() > 0) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                ships.forEach(enemyShip -> {
                    enemyShip.move(Direction.DOWN, getSpeed());
                });
            }
            if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                ships.forEach(enemyShip -> {
                    enemyShip.move(Direction.DOWN, getSpeed());
                });
            } else {
                ships.forEach(enemyShip -> {
                    enemyShip.move(direction, getSpeed());
                });
            }
        }
    }
}