package board;

import application.Entity;

import java.awt.*;

public class BoardTile extends Entity {
    /**
     * Constructor for the tiles, constructing the gameBoard
     *
     * @param xPos        Хоризонтална позиция на gameBoard
     * @param yPos        Вертикална позиция на gameBoard
     */
    public BoardTile(int xPos, int yPos, Color borderColor, Color fillColor) {
        super(xPos, yPos);
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    /**
     *
     * Метод ,използван за мърдане
     * */
    public void render(Graphics g) {
        g.setColor(borderColor);
        g.drawRect(coordX - 1, coordY - 1, entitySize + 1, entitySize + 1);
        g.setColor(fillColor);
        g.fillRect(coordX, coordY, entitySize, entitySize);
    }
}
