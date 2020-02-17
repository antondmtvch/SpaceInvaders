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
        if (bullets.size() > 0 && this.isAlive) {
            bullets.forEach(bullet -> {
                if (bullet.isAlive && isCollision(bullet)) {
                    this.kill();
                    bullet.kill();
                }
            });
        }
    }

    @Override
    public Bullet fire() {
        if (!this.isAlive) {
            return null;
        }
        return new Bullet( x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }

    @Override
    public void kill() {
        if (this.isAlive) {
            this.isAlive = false;
            super.setAnimatedView(
                    ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER
            );
        }
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void move() {
        if (this.isAlive) {
            double X = this.x;
            switch (this.direction) {
                case LEFT: X -= 1; break;
                case RIGHT: X += 1; break;
            }
            if (X < 0) {
                this.x = 0;
            } else if (X + this.width > SpaceInvadersGame.WIDTH) {
                this.x = SpaceInvadersGame.WIDTH - this.width;
            } else {
                this.x = X;
            }
        }
    }
}
