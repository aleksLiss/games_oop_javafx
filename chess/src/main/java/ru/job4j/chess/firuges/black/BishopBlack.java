package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - this.position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = getDeltas(position, dest)[0];
        int deltaY = getDeltas(position, dest)[1];
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int startX = source.getX();
        int startY = source.getY();
        int finishX = dest.getX();
        int finishY = dest.getY();
        int deltaX, deltaY;
        deltaX = getDeltas(source, dest)[0];
        deltaY = getDeltas(source, dest)[1];
        while (startX != finishX
                || startY != finishY) {
            startX += deltaX;
            startY += deltaY;
            if (startY > 7 || startX > 7) {
                break;
            }
        }
        return startX == finishX && startY == finishY;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private static int[] getDeltas(Cell source, Cell dest) {
        int startX = source.getX();
        int startY = source.getY();
        int finishX = dest.getX();
        int finishY = dest.getY();
        int deltaX, deltaY;
        if (finishX < startX && finishY < startY) {
            deltaX = -1;
            deltaY = -1;
        } else if (finishX > startX && finishY < startY) {
            deltaX = 1;
            deltaY = -1;
        } else if (finishX > startX && finishY > startY) {
            deltaX = 1;
            deltaY = 1;
        } else {
            deltaX = -1;
            deltaY = 1;
        }
        return new int[]{deltaX, deltaY};
    }
}
