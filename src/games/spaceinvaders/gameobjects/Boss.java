package games.spaceinvaders.gameobjects;

import games.spaceinvaders.ShapeMatrix;

public class Boss extends EnemyShip {

    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        this.setAnimatedView(ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
    }

    @Override
    public void nextFrame() {
        this.frameCount += 1;
        if (frameCount % 10 == 0 || !this.isAlive) {
            super.nextFrame();
        }
    }
}