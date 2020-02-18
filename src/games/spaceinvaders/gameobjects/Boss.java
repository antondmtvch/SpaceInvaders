package games.spaceinvaders.gameobjects;

import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;

public class Boss extends EnemyShip {

    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        this.score = 100;
        this.setAnimatedView(true,
                ShapeMatrix.BOSS_ANIMATION_FIRST,
                ShapeMatrix.BOSS_ANIMATION_SECOND
        );
    }

    @Override
    public Bullet fire() {
        if (!this.isAlive) {
            return null;
        }
        if (this.matrix == ShapeMatrix.BOSS_ANIMATION_FIRST) {
            return new Bullet(this.x + 6, this.y + this.height, Direction.DOWN);
        }
        return new Bullet(this.x, this.y + this.height, Direction.DOWN);
    }

    @Override
    public void kill() {
        if (this.isAlive) {
            this.isAlive = false;
            super.setAnimatedView(false,
                    ShapeMatrix.KILL_BOSS_ANIMATION_FIRST,
                    ShapeMatrix.KILL_BOSS_ANIMATION_SECOND,
                    ShapeMatrix.KILL_BOSS_ANIMATION_THIRD
            );
        }
    }

    @Override
    public void nextFrame() {
        this.frameCount++;
        if (frameCount % 10 == 0 || !this.isAlive) {
            super.nextFrame();
        }
    }
}