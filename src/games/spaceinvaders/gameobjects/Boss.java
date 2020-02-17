package games.spaceinvaders.gameobjects;

import games.spaceinvaders.ShapeMatrix;

public class Boss extends EnemyShip {

    public Boss(double x, double y) {
        super(x, y);
        this.setAnimatedView(ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
    }
}
