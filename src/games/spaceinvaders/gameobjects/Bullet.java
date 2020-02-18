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
            this.dy--;
        } else {
            this.dy++;
        }
    }

    public void move() {
        this.y = this.y + this.dy;
    }

    public void kill() {
        this.isAlive = false;
    }
}