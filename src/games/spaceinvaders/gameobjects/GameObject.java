package games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class GameObject {

    public double x;
    public double y;
    public int[][] matrix;
    public int height;
    public int width;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.height = matrix.length;
        this.width = matrix[0].length;
    }

    public void draw(Game game) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                game.setCellValueEx((int) x + j, (int) y + i, Color.values()[matrix[i][j]], "");
            }
        }
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "x=" + x +
                ", y=" + y +
                ", matrix=" + Arrays.toString(matrix) +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
