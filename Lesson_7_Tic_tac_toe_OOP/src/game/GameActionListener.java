package game;

import com.sun.prism.paint.RadialGradient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {


    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton) { //Ссылку на кнопку которую мы привязываем
        button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();   //Через клавишу получим ссылку на борд

        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

        if (board.isTurnable(row, cell)) { //Если кнопка не занята - ставим символ игрока
            board.getGame().getCurrentPlayer().updateByPlayersData(button); //Ход человека

            if (board.isFull()) { //Если поле заполнено
                button.getBoard().getGame().showMessageText("Ничья!");
                board.emptyField();
            }
            else if(!board.getGame().getCurrentPlayer().isRealPlayer()){
                board.getGame().getCurrentPlayer().updateByAiData(button);
            }
        } else { //Сообщаем об ошибке
            board.getGame().showMessageText("Не корректный ход!");
            System.out.println();
        }

        if (board.isFull()) { //Проверяем еще раз. У меня, почему - то не всегда проверяло ничью
            board.getGame().showMessageText("Ничья!");
            board.emptyField();
        }
        System.out.println(board.isFull());
    }

}
