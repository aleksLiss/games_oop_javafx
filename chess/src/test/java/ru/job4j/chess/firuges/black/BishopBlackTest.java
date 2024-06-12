package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenCreateBishopBlackThenPositionC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell expected = Cell.C8;
        Cell result = bishopBlack.position();
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenCreateBishopBlackThenPositionF8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell expected = Cell.F8;
        Cell result = bishopBlack.position();
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenMoveBishopBlackFromC8ThenNewPositionF5() {
        BishopBlack oldBishopBlack = new BishopBlack(Cell.C8);
        BishopBlack newBishopBlack = (BishopBlack) oldBishopBlack.copy(Cell.F5);
        Cell expected = Cell.F5;
        Cell result = newBishopBlack.position();
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenMoveBishopBlackFromF8ThenNewPositionA3() {
        BishopBlack oldBishopBlack = new BishopBlack(Cell.F8);
        BishopBlack newBishopBlack = (BishopBlack) oldBishopBlack.copy(Cell.A3);
        Cell expected = Cell.A3;
        Cell result = newBishopBlack.position();
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenMoveBishopBlackFromG1ThenNewPositionC5() {
        BishopBlack oldBishopBlack = new BishopBlack(Cell.G1);
        Cell[] result = oldBishopBlack.way(Cell.C5);
        Cell[] expected = new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5};
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenMoveBishopBlackFromC8ThenNewPositionE6() {
        BishopBlack oldBishopBlack = new BishopBlack(Cell.C8);
        Cell[] result = oldBishopBlack.way(Cell.E6);
        Cell[] expected = new Cell[]{Cell.D7, Cell.E6};
        assertThat(expected).isEqualTo(result);
    }
}