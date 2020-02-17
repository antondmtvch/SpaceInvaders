package games.spaceinvaders.gameobjects;

public class Ship extends GameObject {

    public Ship(double x, double y) {
        super(x, y);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        this.nextFrame();
    }

    public void setStaticView(int[][] viewFrame) {
        super.setMatrix(viewFrame);
    }

    public Bullet fire() {
        return null;
    }
}