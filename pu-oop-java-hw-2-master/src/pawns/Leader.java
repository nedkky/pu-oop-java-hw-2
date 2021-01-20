package pawns;

import enums.Nation;

import java.awt.*;

public class Leader extends Pawn {
    /**
     * Конструктор на Лидер
     *
     * @param xPos   Хоризонтална позиция на gameBoard
     * @param yPos   Вертикална  позиция на gameBoard
     */

    public Leader(int xPos, int yPos, Nation nation) {
        super(xPos, yPos, nation);
    }

    /**
     * Метод за визуализиране на Лидер на gameBoard
     *
     */

    @Override
    public void render(Graphics g) {
        g.setColor(fillColor);
        g.fillRect(coordX + inTileOffset, coordY + inTileOffset, pawnSize, pawnSize);
    }

}
