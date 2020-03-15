package games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {

    public boolean isAlive = true;
    private boolean loopAnimation = false;
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
        frames = new ArrayList<int[][]>();
        frameIndex = 0;
        frames.add(viewFrame);
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        super.setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
        loopAnimation = isLoopAnimation;
    }

    public void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size() && loopAnimation) {
            frameIndex = 0;
        }
        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    public boolean isVisible() {
        return isAlive || frameIndex < frames.size();

    }
}