package games.spaceinvaders.gameobjects;

import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;

public class EnemyShip extends Ship {

    public EnemyShip(double x, double y) {
        super(x, y);
        super.setStaticView(ShapeMatrix.ENEMY);
    }

    @Override
    public Bullet fire() {
        return new Bullet(this.x + 1, this.y + this.height, Direction.DOWN);
    }

    public void move(Direction direction, double speed) {
        switch (direction) {
            case RIGHT:
                this.x = x + speed;
                break;
            case LEFT:
                this.x = x - speed;
                break;
            case DOWN:
                this.y = y + 2.0;
                break;
        }
    }
}