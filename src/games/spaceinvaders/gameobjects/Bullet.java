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
            this.dy = -1;
        } else this.dy = 1;
    }

    public void move() {
        this.y = this.y + this.dy;
    }

    public void kill() {
        this.isAlive = false;
    }
}