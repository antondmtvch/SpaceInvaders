package games.spaceinvaders.gameobjects;

import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;

public class EnemyShip extends Ship {

    public EnemyShip(double x, double y) {
        super(x, y);
        super.setStaticView(ShapeMatrix.ENEMY);
    }

    public void move(Direction direction, double speed) {
        if (direction == Direction.RIGHT) {
            this.x = x + speed;
        }
        if (direction == Direction.LEFT) {
            this.x = x - speed;
        }
        if (direction == Direction.DOWN) {
            this.y = y + 2;
        }
    }
}