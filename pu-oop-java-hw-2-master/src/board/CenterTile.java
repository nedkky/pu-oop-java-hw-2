package board;

import java.awt.*;

public class CenterTile extends BoardTile {

    Color circleFill;
    Color circleBorder;

    /**
     *
     * @param xPos         Хоризонтална позиция на gameBoard
     * @param yPos         Вертикална  позиция на gameBoard
     */
    public CenterTile(int xPos, int yPos, Color borderColor, Color fillColor, Color circleBorder, Color circleFill) {
        super(xPos, yPos, borderColor, fillColor);
        this.circleBorder = circleBorder;
        this.circleFill = circleFill;
    }

    /**
     *
     * Метод , използван за мърдане
     */
    @Override
    public void render(Graphics g) {
        super.render(g);
        int ovalSize = entitySize / 4;
        g.setColor(circleBorder);
        g.fillOval(coordX + ovalSize - 1, coordY + ovalSize - 1, ovalSize * 2 + 2, ovalSize * 2 + 2);
        g.setColor(circleFill);
        g.fillOval(coordX + ovalSize, coordY + ovalSize, ovalSize * 2, ovalSize * 2);
    }

}