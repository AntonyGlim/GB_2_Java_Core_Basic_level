// +
package game;

import java.util.Random;

public class GamePlayer {
    private char playerSign;            //Символ которым играет игрок
    private boolean realPlayer = true;  //Реальный игрок

    public GamePlayer(boolean isRealPlayer, char playerSign){
        this.realPlayer = isRealPlayer;
        this.playerSign = playerSign;
    }

    public boolean isRealPlayer(){
        return realPlayer;
    }

    public char getPlayerSign(){
        return playerSign;
    }

    /**
     * Необходимо устанавливать в положение true при нажатии на "Новая игра
     * @param realPlayer
     */
    public void setRealPlayer(boolean realPlayer) {
        this.realPlayer = realPlayer;
    } //Me



    void updateByPlayersData(GameButton button){
        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

        //Обновляем матрицу игры
        button.getBoard().updateGameField(row, cell);

        //Обновляем содержимое кнопки
        button.setText(Character.toString( button.getBoard().getGame().getCurrentPlayer().getPlayerSign())); //Чар и стринг не идентичные

        if ( button.getBoard().checkWin()){//Если победа
            button.getBoard().getGame().showMessageText("Вы победили!");
            button.getBoard().emptyField();
        } else {//Передаем ход
            button.getBoard().getGame().passTurn();
        }
        button.getBoard().getGame().getCurrentPlayer().setRealPlayer(!( button.getBoard().getGame().getCurrentPlayer().isRealPlayer())); //меняем значение на не реального игрока
    }


    void updateByAiData(GameButton button){
        int x;
        int y;
        Random random = new Random();  //Режим глупого ПК

        do {
            y = random.nextInt(GameBoard.dimension);
            x = random.nextInt(GameBoard.dimension);
        }
        while (!button.getBoard().isTurnable(x, y));

        //обновим матрицу игры
        button.getBoard().updateGameField(x, y);

        //обновить содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        button.getBoard().getButton(cellIndex).setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));

        //Проверить победу
        if(button.getBoard().checkWin()){
            button.getBoard().getGame().showMessageText("ПК Выиграл");
            button.getBoard().emptyField();
        } else {
            // передаем ход
            button.getBoard().getGame().passTurn();
        }
        button.getBoard().getGame().getCurrentPlayer().setRealPlayer(!(button.getBoard().getGame().getCurrentPlayer().isRealPlayer()));
    }
}
