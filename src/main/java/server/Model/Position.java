package server.Model;

/**
 * Created by boivi_000 on 2014-12-13.
 * Coordinate construct used to store bidimensional positions.
 */

public class Position {
    private int posX;
    private int posY;

    public Position(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public Position() {
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {

        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position)
        {
            Position input = (Position) obj;

            return input.posX == this.posX && input.posY == this.posY;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        return result;
    }
}
