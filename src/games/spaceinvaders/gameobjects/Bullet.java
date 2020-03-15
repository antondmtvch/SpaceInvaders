package games.spaceinvaders.gameobjects;

import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;

public class Bullet extends GameObject {

    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        super.setMatrix(ShapeMatrix.BULLET);
        if (direction == Direction.UP) {
            dy--;
        } else {
            dy++;
        }
    }

    public void move() {
        y = y + dy;
    }

    public void kill() {
        isAlive = false;
    }
}