//+
package game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex; //Номер кнопки
    private GameBoard board; //Ссылка на игровое поле

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard){
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.dimension;
        int cellNum = buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5); //150 - 5 чтоб кнопки были чуть меньше
        addActionListener(new GameActionListener(rowNum, cellNum, this)); //this - ссылка на текущую кнопку
    }

    public GameBoard getBoard(){return board;}

    public int getButtonIndex() {
        return buttonIndex;
    }
}
