package pawns;

import application.Entity;
import enums.Nation;

import java.awt.*;

public abstract class Pawn extends Entity {

    protected final int sizeScale = 2;
    protected final int offsetScale = 2;
    protected int inTileOffset;
    protected int pawnSize;

    /**
     * @param xPos   Хоризонтална позиция на gameBoard
     * @param yPos   Вертикална позиция на gameBoard
     */

    protected Pawn(int xPos, int yPos, Nation nation) {
        super(xPos, yPos);
        this.borderColor = nation.borderColor;
        this.fillColor = nation.fillColor;
        this.inTileOffset = offset / offsetScale;
        this.pawnSize = entitySize / sizeScale;
    }


    public abstract void render(Graphics g);
}
