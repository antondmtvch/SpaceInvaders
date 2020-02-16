package games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EnemyFleet {

    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;

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
        for (EnemyShip enemyShip : ships) {
            enemyShip.draw(game);
        }
    }

    private double getLeftBorder() {
        List<EnemyShip> copyOfShips = new ArrayList<>(ships);
        copyOfShips.sort(Comparator.comparing(s -> s.x));
        return copyOfShips.get(0).x;
    }

    private double getRightBorder() {
        List<EnemyShip> copyOfShips = new ArrayList<>(ships);
        for (EnemyShip enemyShip : copyOfShips) {
            enemyShip.x = enemyShip.x + enemyShip.width;
        }
        copyOfShips.sort(Comparator.comparing(s -> s.x));
        return copyOfShips.get(copyOfShips.size() - 1).x;
    }
}