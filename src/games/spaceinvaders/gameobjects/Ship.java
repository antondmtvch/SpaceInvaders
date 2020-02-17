package games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {

    public boolean isAlive = true;
    private List<int[][]> frames;
    private int frameIndex;

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
        this.frames = new ArrayList<int[][]>();
        this.frameIndex = 0;
        frames.add(viewFrame);
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        this.isAlive = false;
    }

    public void setAnimatedView(int[][]... viewFrames) {
        super.setMatrix(viewFrames[0]);
        this.frames = Arrays.asList(viewFrames);
        this.frameIndex = 0;
    }

    public void nextFrame() {
        this.frameIndex += 1;
        if (this.frameIndex < this.frames.size()) {
            this.matrix = frames.get(this.frameIndex);
        }
    }

    public boolean isVisible() {
        return this.isAlive || this.frameIndex < this.frames.size();

    }
}