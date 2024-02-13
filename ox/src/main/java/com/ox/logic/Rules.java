package com.ox.logic;

import com.ox.actors.Player;

public class Rules {
    //private static List<Character> moves;
    //private static List<List<Character>> moves;
    private static Character[][] board;

    private static int boardSizeX = 3;
    private static int boardSizeY = 3;
    private static int inRowToWin = 3;
    private static boolean gameInProgress = false;
    private static int strike = 0;

    public static boolean isGameInProgress() {
        return gameInProgress;
    }

    public static void setGameInProgress(boolean gameInProgress) {
        Rules.gameInProgress = gameInProgress;
    }

    public static int getBoardSizeX() {
        return boardSizeX;
    }

    public static void setBoardSizeX(int boardSizeX) {
        Rules.boardSizeX = boardSizeX;
    }

    public static int getBoardSizeY() {
        return boardSizeY;
    }

    public static void setBoardSizeY(int boardSizeY) {
        Rules.boardSizeY = boardSizeY;
    }

    public static void setInRowToWin(int inRowToWin) {
        if (boardSizeY >= inRowToWin && boardSizeX >= inRowToWin) {
            Rules.inRowToWin = inRowToWin;
        }
    }

    public static Character[][] getMoves() {
        return board;
    }

    public static Character[][] getBoard() {
        return board;
    }

    public static void generateBoard(Character character) {
        board = new Character[boardSizeX][boardSizeY];
        for (int xi = 0; xi < boardSizeX; xi++) {
            for (int yi = 0; yi < boardSizeY; yi++) {
                board[xi][yi] = character;
            }
        }
    }

    public static void addMoveToBoard(String s, Player p) throws Exception {
        int move = Integer.parseInt(s);
        if (board[move / 10 - 1][move % 10 - 1].equals(' ')) {
            board[move / 10 - 1][move % 10 - 1] = p.getPlayerSymbol();
        } else {
            throw new Exception();
        }
    }

    public static byte gameStatus() {
        if(isVerticalStrike() || isHorizontalStrike() || isDiagonalStrikeLeftRight() || isDiagonalStrikeRightLeft()) {
            return 1;
        } else if(isBoardFull()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static boolean isVerticalStrike() {
        //looks for vertical strike
        strike = 0;
        for (int yi = 0; yi < board[0].length; yi++) {
            for (int xi = 0; xi < board.length - 1; xi++) {
                if (!board[xi][yi].equals(' ')) {
                    if (board[xi][yi].equals(board[xi + 1][yi])) {
                        strike++;
                        if (strike == inRowToWin - 1) {
                            return true; //game finished - player won
                        }
                    } else {
                        strike = 0;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isHorizontalStrike() {
        //looks for horizontal strike
        strike = 0;
        for (int xi = 0; xi < board.length; xi++) {
            for (int yi = 0; yi < board[0].length - 1; yi++) {
                if (!board[xi][yi].equals(' ')) {
                    if (board[xi][yi].equals(board[xi][yi + 1])) {
                        strike++;
                        if (strike == inRowToWin - 1) {
                            return true; //game finished - player won
                        }
                    } else {
                        strike = 0;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isDiagonalStrikeLeftRight() {
        //looks for diagonal strike(left-right)
        strike = 0;
        for (int yi = board[0].length - 1; yi > 0; yi--) {
            for (int xi = board.length - 1; xi > 0; xi--) {
                if (!board[xi][yi].equals(' ')) {
                    if (board[xi][yi].equals(board[xi - 1][yi - 1])) {
                        strike++;
                        if (strike == inRowToWin - 1) {
                            return true; //game finished - player won
                        }
                    } else {
                        strike = 0;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isDiagonalStrikeRightLeft() {
        //looks for diagonal strike(right-left)
        strike = 0;
        for (int yi = 0; yi < board[0].length - 1; yi++) {
            for (int xi = board.length - 1; xi > 0; xi--) {
                if (!board[xi][yi].equals(' ')) {
                    if (board[xi][yi].equals(board[xi - 1][yi + 1])) {
                        strike++;
                        if (strike == inRowToWin - 1) {
                            return true; //game finished - player won
                        }
                    } else {
                        strike = 0;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isBoardFull() {
        //looks if board is full
        strike = 0;
        for (int xi = 0; xi < board.length; xi++) {
            for (int yi = 0; yi < board[xi].length; yi++) {
                if (board[xi][yi].equals(' ')) {
                    return false;
                }
            }
        }
        return true; //game finished - board is full
    }
}
