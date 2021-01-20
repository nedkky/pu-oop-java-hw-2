package board;

import enums.Colors;
import enums.Nation;
import pawns.Guard;
import pawns.Leader;
import pawns.Pawn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends JFrame {

    ArrayList<BoardTile> tiles;
    ArrayList<Pawn> yellowSide;
    ArrayList<Pawn> greenSide;


    public GameBoard() {
        this.tiles = setTiles();
        this.yellowSide = setYellowSide();
        this.greenSide = setGreenSide();

        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        paintTiles(g);
        paintEnemySides(g);
    }


    private void paintTiles(Graphics g) {
        for (BoardTile tile : tiles) {
            tile.render(g);
        }
    }


    private void paintEnemySides(Graphics g) {
        for (int i = 0; i < 5; i++) {
            yellowSide.get(i).render(g);
            greenSide.get(i).render(g);
        }
    }


    private ArrayList<Pawn> setYellowSide() {
        ArrayList<Pawn> pawns = new ArrayList<>();

        for (int i = 0; i < 4; i++) pawns.add(new Guard(i, 0, Nation.YELLOW));
        pawns.add(new Leader(4, 0, Nation.YELLOW));

        return pawns;
    }


    private ArrayList<Pawn> setGreenSide() {
        ArrayList<Pawn> pawns = new ArrayList<>();

        for (int i = 4; i > 0; i--) pawns.add(new Guard(i, 4, Nation.GREEN));
        pawns.add(new Leader(0, 4, Nation.GREEN));

        return pawns;
    }


    private ArrayList<BoardTile> setTiles() {
        ArrayList<BoardTile> tempTiles = new ArrayList<>();
        tempTiles.addAll(getTileColumn(0, false));
        tempTiles.addAll(getTileColumn(1, true));
        tempTiles.addAll(getCenterColumn());
        tempTiles.addAll(getTileColumn(3, true));
        tempTiles.addAll(getTileColumn(4, false));
        return tempTiles;
    }

    /**
     *
     * @param xPos      Хоризонтална позиция на gameBoard
     */
    private ArrayList<BoardTile> getTileColumn(int xPos, boolean isReverse) {
        int yPos = 0;
        int dir = (isReverse) ? 4 : 0;

        ArrayList<BoardTile> standardTileColumn = new ArrayList<>();

        standardTileColumn.add(new BoardTile(xPos, Math.abs(dir - yPos++), Colors.GRAPHITE.color, Colors.PEACH.color));
        standardTileColumn.add(new BoardTile(xPos, Math.abs(dir - yPos++), Colors.GRAPHITE.color, Colors.GRAY.color));
        standardTileColumn.add(new BoardTile(xPos, Math.abs(dir - yPos++), Colors.GRAPHITE.color, Colors.WHITE.color));
        standardTileColumn.add(new BoardTile(xPos, Math.abs(dir - yPos++), Colors.GRAPHITE.color, Colors.GRAY.color));
        standardTileColumn.add(new BoardTile(xPos, Math.abs(dir - yPos), Colors.GRAPHITE.color, Colors.GRAPHITE.color));

        return standardTileColumn;
    }


    private ArrayList<BoardTile> getCenterColumn() {
        int yPos = 0;
        int xPos = 2;

        ArrayList<BoardTile> centerTileColumn = new ArrayList<>();

        centerTileColumn.add(new BoardTile(xPos, yPos++, Colors.GRAPHITE.color, Colors.WHITE.color));
        centerTileColumn.add(new BoardTile(xPos, yPos++, Colors.GRAPHITE.color, Colors.WHITE.color));
        centerTileColumn.add(new CenterTile(xPos, yPos++, Colors.GRAPHITE.color, Colors.WHITE.color, Colors.GRAPHITE.color, Colors.GRAY.color));
        centerTileColumn.add(new BoardTile(xPos, yPos++, Colors.GRAPHITE.color, Colors.WHITE.color));
        centerTileColumn.add(new BoardTile(xPos, yPos, Colors.GRAPHITE.color, Colors.WHITE.color));

        return centerTileColumn;
    }

}
