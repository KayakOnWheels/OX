package com.ox;

import com.ox.actors.HumanPlayer;
import com.ox.actors.Player;
import com.ox.ioController.OutputController;
import com.ox.logic.Rules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.ox.logic.Rules.*;

class OxApplicationTests {

    @Test
    void gameStatusShouldReturn1WhenDiagonalStrikeFromRightToLeft() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard(' ');
        Rules.getBoard()[0][3] = 'x';
        Rules.getBoard()[1][2] = 'x';
        Rules.getBoard()[2][1] = 'x';
        Rules.getBoard()[3][0] = 'x';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isDiagonalStrikeRightLeft();

        //Then
        Assertions.assertEquals(1, result);
        Assertions.assertTrue(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenDiagonalStrikeFromLeftToRight() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(3);
        generateBoard(' ');
        Rules.getBoard()[0][0] = 'x';
        Rules.getBoard()[1][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isDiagonalStrikeLeftRight();

        //Then
        Assertions.assertEquals(1, result);
        Assertions.assertTrue(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenDiagonalStrikeFromLeftToRightCase2() {
        //Given
        setBoardSizeX(6);
        setBoardSizeY(6);
        setInRowToWin(5);
        generateBoard(' ');
        Rules.getBoard()[0][0] = 'x';
        Rules.getBoard()[1][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        Rules.getBoard()[3][3] = 'x';
        Rules.getBoard()[1][0] = 'o';
        Rules.getBoard()[2][0] = 'o';
        Rules.getBoard()[2][1] = 'o';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isDiagonalStrikeLeftRight();

        //Then
        Assertions.assertEquals(0, result);
        Assertions.assertFalse(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenDiagonalStrikeFromLeftToRightCase3() {
        //Given
        setBoardSizeX(6);
        setBoardSizeY(6);
        setInRowToWin(5);
        generateBoard(' ');
        Rules.getBoard()[0][0] = 'x';
        Rules.getBoard()[1][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        Rules.getBoard()[3][3] = 'x';
        Rules.getBoard()[4][4] = 'x';
        Rules.getBoard()[1][0] = 'o';
        Rules.getBoard()[2][0] = 'o';
        Rules.getBoard()[2][1] = 'o';
        Rules.getBoard()[3][2] = 'o';
        Rules.getBoard()[4][3] = 'o';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isDiagonalStrikeLeftRight();

        //Then
        Assertions.assertEquals(1, result);
        Assertions.assertTrue(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenHorizontalStrike() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(3);
        generateBoard(' ');
        Rules.getBoard()[2][0] = 'x';
        Rules.getBoard()[2][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        Rules.getBoard()[1][3] = 'x';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isHorizontalStrike();

        //Then
        Assertions.assertEquals(1, result);
        Assertions.assertTrue(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenVerticalStrike() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard(' ');
        Rules.getBoard()[1][3] = 'x';
        Rules.getBoard()[2][3] = 'x';
        Rules.getBoard()[3][3] = 'x';
        Rules.getBoard()[0][3] = 'x';
        OutputController.printGameBoard();

        //When
        int result = gameStatus();
        boolean result2 = isVerticalStrike();

        //Then
        Assertions.assertEquals(1, result);
        Assertions.assertTrue(result2);
    }

    @Test
    void gameStatusShouldReturn1WhenVerticalStrikeCase2() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(3);
        generateBoard(' ');
        Rules.getBoard()[1][1] = 'o';
        Rules.getBoard()[2][1] = 'o';
        Rules.getBoard()[2][0] = 'x';
        Rules.getBoard()[3][0] = 'x';
        OutputController.printGameBoard();

        //When
        boolean result2 = isVerticalStrike();

        //Then
        Assertions.assertFalse(result2);
    }

    @Test
    void gameStatusShouldReturnMinus1WhenNoMoreFieldsToPlay() {
        //Given
        generateBoard('x'); //empty board
        OutputController.printGameBoard();

        //When
        boolean result = isBoardFull();

        //Then

        Assertions.assertTrue(result);
    }

    @Test
    void addMoveToBoardShouldThrowErrorWhenFieldOccupied() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard(' ');
        Rules.getBoard()[1][3] = 'x';
        OutputController.printGameBoard();
        Player player1 = new HumanPlayer("player");

        //When

        //Then
        Assertions.assertThrows(Exception.class, () -> addMoveToBoard("24", player1));
    }


}
