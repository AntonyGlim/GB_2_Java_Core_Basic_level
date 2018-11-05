
//+
package game;

import com.sun.deploy.panel.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 3;           //Размерность
    static int cellSize = 150;          //Размер 1 клетки
    private char[][] gameField;         //Матрица игры
    private GameButton[] gameButtons;   //Массив кнопок

    private Game game;                  //Ссылка на игру

    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    /**
     * Метод инициации и отрисовки игрового поля
     */
    private void initField(){           //Отрисовка поля
        //Основные настройки
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300); //Размер поля гибкий и равен размерности игры на размер кнопки
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(); //Панель управления игрой
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        //панель самой игры
        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension]; //Одномерный, т.к. кнопкам присвоены индексы

        //заполним поле кнопками
        for (int i = 0; i < (dimension * dimension) ; i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton; //Добавляем полученную ссылку
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Метод очиски игрового поля
     */
    void emptyField(){
        for (int i = 0; i < (dimension * dimension); i++) {
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame(){
        return game;
    }

    /**
     * Метод проверки пустое-ли поле
     * @param x
     * @param y
     * @return
     */
    boolean isTurnable(int x, int y){
        boolean result = false;

        if(gameField[y][x] == nullSymbol)
            result = true;

        return result;
    }

    /**
     * Обновление игрового поля (получаем координаты, и их обновляем
     * x - по горизонтали
     * y - по вертикали
     */
    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    /**
     * Проверка победы по столбцам и линиям
     * @return Флаг победы
     */
    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol) ){
            result = true;
        }
        return result;
    }

    private boolean checkWinLines(char playerSymbol) {
        boolean cols, rows, result;
        result = false;

        for (int col = 0; col < dimension; col++) { //TODO заменить на 1 цикл
            cols = true;
            rows = true;

            for (int row = 0; row < dimension; row++) {
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }

            if (cols || rows) { //ели найдем комбинацию - сразу выйдем
                result = true;
                break;
            }

            if (result) {
                break;
            }
        }
        return result;
    }


    private boolean checkWinDiagonals(char playerSymbol) {
        boolean leftRight, rightLeft, result;
        leftRight = true;
        rightLeft = true;
        result = false;

        for (int i = 0; i < dimension; i++) { //TODO заменить на 1 цикл
            leftRight &= (gameField[i][i] == playerSymbol);
            rightLeft &= (gameField[dimension - i - 1][i] == playerSymbol);
        }

        if (leftRight || rightLeft) {
            result = true;
        }
        return result;
    }

    /**
     * Проверка заполненности поля
     * @return
     */
    boolean isFull() {
        boolean result = true;

        for (int i = 0; i < dimension; i++) {   //TODO можно использовать 1 цикл и добавить выход из цикла
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol) {
                    result = false;
                }
            }
        }
        return result;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }


}
