package game;

import javax.swing.*;

public class Game {
    private GameBoard board;                                //Ссылка на игровое поле
    private GamePlayer[] gamePlayers = new GamePlayer[2];   //Массив игроков
    private int playersTurn = 0;                            //Индекс текущего игрока

    public Game(){
        this.board = new GameBoard(this);       //передаем текущий экземпляр нашей игры
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true, 'X');
        gamePlayers[1] = new GamePlayer(false, 'O');
    }

    /**
     * Метод передачи хода
     */
    void passTurn(){
        if (playersTurn == 0){
            playersTurn = 1;
        } else {
            playersTurn = 0;
        }
    }

    /**
     * Получение о-та текущего игрока
     * @return GamePlayer о-кт игры
     */
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }

    /**
     * Метод показа popup-a для пользователя
     */
    void showMessageText (String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }
}
