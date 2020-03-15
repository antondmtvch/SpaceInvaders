package games.spaceinvaders.gameobjects;

import games.spaceinvaders.Direction;
import games.spaceinvaders.ShapeMatrix;
import games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {

    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0 , SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        this.setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (bullets.size() > 0 && isAlive) {
            bullets.forEach(bullet -> {
                if (bullet.isAlive && isCollision(bullet)) {
                    kill();
                    bullet.kill();
                }
            });
        }
    }

    @Override
    public Bullet fire() {
        if (!isAlive) {
            return null;
        }
        return new Bullet( x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            super.setAnimatedView(false,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER
            );
        }
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            direction = newDirection;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        if (isAlive) {
            double X = x;
            switch (direction) {
                case LEFT: X--; break;
                case RIGHT: X++; break;
            }
            if (X < 0) {
                x = 0;
            } else if (X + width > SpaceInvadersGame.WIDTH) {
                x = SpaceInvadersGame.WIDTH - width;
            } else {
                x = X;
            }
        }
    }

    public void win() {
        super.setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
