package pawns;

import enums.Nation;

import java.awt.*;

public class Guard extends Pawn {
    /**
     * Constructor for a Guard object
     *
     * @param xPos   Хоризонтална позиция на gameBoard
     * @param yPos   Вертикална  позиция на gameBoard
     */
    public Guard(int xPos, int yPos, Nation nation) {
        super(xPos, yPos, nation);
    }

    /**
     * Метод за визуализиране на  Guard на gameBoard
     *
     */


    @Override
    public void render(Graphics g) {
        int sizeDiff = 5;
        g.setColor(borderColor);
        g.fillOval(coordX + inTileOffset, coordY + inTileOffset, pawnSize, pawnSize);
        g.setColor(fillColor);
        g.fillOval(
                coordX + inTileOffset + sizeDiff,
                coordY + inTileOffset + sizeDiff,
                pawnSize - sizeDiff * 2,
                pawnSize - sizeDiff * 2);
    }
}
