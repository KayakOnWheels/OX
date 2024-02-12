package com.ox;

import com.ox.IOController.OutputController;
import com.ox.actors.HumanPlayer;
import com.ox.actors.Player;
import com.ox.logic.Rules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ox.logic.Rules.*;

@SpringBootTest
class OxApplicationTests {

    @Test
    void gameStatusShouldReturn1WhenUserWonCase1() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard();
        Rules.getBoard()[0][3] = 'x';
        Rules.getBoard()[1][2] = 'x';
        Rules.getBoard()[2][1] = 'x';
        Rules.getBoard()[3][0] = 'x';

        //When
        int result = gameStatus();

        //Then
        OutputController.printGameBoard();
        Assertions.assertEquals(1, result);
    }

    @Test
    void gameStatusShouldReturn1WhenUserWonCase2() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard();
        Rules.getBoard()[0][0] = 'x';
        Rules.getBoard()[1][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        Rules.getBoard()[3][3] = 'x';

        //When
        int result = gameStatus();

        //Then
        OutputController.printGameBoard();
        Assertions.assertEquals(1, result);
    }

    @Test
    void gameStatusShouldReturn1WhenUserWonCase3() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(3);
        generateBoard();
        Rules.getBoard()[2][0] = 'x';
        Rules.getBoard()[2][1] = 'x';
        Rules.getBoard()[2][2] = 'x';
        Rules.getBoard()[1][3] = 'x';

        //When
        int result = gameStatus();

        //Then
        OutputController.printGameBoard();
        Assertions.assertEquals(1, result);
    }

    @Test
    void gameStatusShouldReturn1WhenUserWonCase4() {
        //Given
        setBoardSizeX(4);
        setBoardSizeY(4);
        setInRowToWin(4);
        generateBoard();
        Rules.getBoard()[1][3] = 'x';
        Rules.getBoard()[2][3] = 'x';
        Rules.getBoard()[3][3] = 'x';
        Rules.getBoard()[0][3] = 'x';


        //When
        int result = gameStatus();

        //Then
        OutputController.printGameBoard();
        Assertions.assertEquals(1, result);
    }

    @Test
    void gameStatusShouldReturnMinus1WhenNoMoreFieldsToPlay() {
        //Given
        generateBoard(); //empty board

        //When
        int result = gameStatus();

        //Then
        OutputController.printGameBoard();
        Assertions.assertEquals(0, result);
    }

    @Test
    void validateInputShouldNotThrowExceptionWhenInputIsM() {
        //Given
        String input = "m";

        //When
        //Then
        Assertions.assertThrows(Exception.class, ()-> validateInput(input));
    }


}
