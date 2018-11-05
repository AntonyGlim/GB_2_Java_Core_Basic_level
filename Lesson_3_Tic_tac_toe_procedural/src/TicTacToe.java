//import com.sun.xml.internal.bind.v2.TODO;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {// Класс будет содержать логику игры
    /*
    Блок настроек игры.
    В нем мы заведем наши штатные переменные.
     */

    private static char[][] map; // Игровое поле
    private static final int SIZE = 5; // Размер игрового поля final

    // Символы для игры игроками
    private static final char DOT_EMPTY = '_';
    private static final char DOT_X = 'x';
    private static final char DOT_O = 'o';

    private static Scanner scanner = new Scanner(System.in); // Экземпляр класса сканер для ввода значений
    private static Random random = new Random();

    private static boolean SILLY_MODE = false;//Режим глупого ПК
    private static boolean MEDIUM_MODE = true;//Режим среднего ПК (если в соседней клетке есть символ)
    private static boolean HARD_MODE = false;//Режим более умного ПК (по очкам каждой клетки) НЕ РЕАЛИЗОВАН


    public static void main(String[] args) { //Ьудет содержать только вызовы основных методов
        initMap();
        printMap();

        while (true){// Цикл бесконечный
            humanTurn(); //ход человека
            if (isEndGame(DOT_X)){// Передавая DOT_X в качестве параметра мы сможем определить, кто выиграл или кому передать ход
                break;
            }
            computerTurn(); //ход ПК
            if (isEndGame(DOT_O)){
                break;
            }
        }

        System.out.println("Игра закончена");
    }


    /**
     * Метод подготовки игрового поля
     * Заполняем поле пустыми элементами
     */
    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
        }
    }


    /**
     * Метод вывода игрового поля в консоль
     */
    private static void printMap(){//Как сократить количество циклов?
        for (int i = 0; i <= map.length; i++)//пропечатываем цифры по верхней границе поля
            System.out.print(i +  "\t");
        System.out.println();

        for (int i = 0; i < map.length; i++){
            System.out.print(i + 1 + "\t");//пропечатываем цифры по левой границе поля
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * Ход человека
     * считывает из консоли 2 координаты, которые ввел человек,
     * и проставляет в указанное поле соответствующий знак.
     * Человек может ввести не корректное значение
     */
    private static void humanTurn(){//
        int x, y;
        do {
            System.out.println("Введите координаты через пробел.");
            System.out.println("1. по вертикали, 2. по горизонтали: ");
            y = scanner.nextInt() - 1; // массив начинается с 0
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }


    /**
     * Генерация случайных чисел "глупого" ПК SILLY_MODE
     * MEDIUM_MODE поставит знак только в клетку, рядом с которой есть похожий символ.
     * Метод будет корректно работать для поля произвольного размера
     */
    private static void computerTurn(){

        if(SILLY_MODE){         //Режим глупого ПК
            enterRandomCell();  //вынесем в отдельный метод генерацию случайных чисел

        }else if (MEDIUM_MODE){ //Реализовать логику более умного компьютера, который определяет свой ход на основании соседних клеток;
            for (int i = 0; i < SIZE ; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isEmpty(map[i][j]) && isNaighbor(i,j) ){//Пустая-ли ячейка, и граничит-ли с подобным символом

                        System.out.println("ПК выбрал ячейку с координатами: " + (j + 1) + " по вертикали, и " +
                                + (i + 1) + " по горизонтали");

                        map[i][j] = DOT_O;
                        i = 1000;// Присваиваем недопустимое значение, чтобы выйти из цикла
                        break;
                    }
                    if (i == SIZE - 1 && j == SIZE - 1){//если похожих символов нет, 1-й ход ПК сделает случайным образом
                        enterRandomCell();
                    }
                }
            }
        }
    }

    /**
     * Генерируем случайные координаты ячейки, и если  они подходят - проставляем в них 0
     */
    private static void enterRandomCell(){
        int x = -1;
        int y = -1;
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(x, y));

        System.out.println("ПК выбрал ячейку с координатами: " + (y + 1) + " по вертикали, и " +
                + (x + 1) + " по горизонтали");
        map[y][x] = DOT_O;
    }


    /**
     * Проверяем, есть-ли в соседней клетке символ который нам нужен
     * @param i - строки массива
     * @param j - столбцы
     * @return - true если в соседней клетке есть нужный символ
     *
     * выглядит громоздко, но зато отработает в случае увеличения увеличения размера поля
     */
    private static boolean isNaighbor(int i, int j){
        boolean isTrue = false;
        if(i == 0 && j == 0){//Клетка с координатами верт 1 гориз 1
            if (isO(map[i + 1][j]) || isO(map[i][j + 1]) || isO(map[i + 1][j + 1])){
                isTrue = true;
                return isTrue;
            }

        } else if (i == 0 && j != 0 && j != SIZE - 1){//Клетка с координатами верт 1 гориз 2
            if (isO(map[i][j - 1]) || isO(map[i][j + 1]) || isO(map[i + 1][j])){
                isTrue = true;
                return isTrue;
            }

        } else if (i == 0 && j == SIZE - 1){//Клетка с координатами верт 1 гориз 3
            if (isO(map[i][j - 1]) || isO(map[i + 1][j - 1]) || isO(map[i + 1][j])){
                isTrue = false;
                return isTrue;
            }

        } else if (i != 0 && i != SIZE - 1 && j == 0){//Клетка с координатами верт 2 гориз 1
            if (isO(map[i - 1][j]) || isO(map[i + 1][j]) || isO(map[i][j + 1])){
                isTrue = true;
                return isTrue;
            }

        } else if (i != 0 && i != SIZE - 1 && j != 0 && j != SIZE - 1){//Клетка с координатами верт 2 гориз 2
            if (isO(map[i - 1][j - 1]) || isO(map[i - 1][j]) || isO(map[i - 1][j + 1]) || isO(map[i][j + 1]) || isO(map[i + 1][j + 1]) || isO(map[i + 1][j]) || isO(map[i + 1][j - 1]) || isO(map[i][j - 1])){
                isTrue = true;
                return isTrue;
            }

        } else if(i != 0 && i != SIZE - 1 && j == SIZE - 1){//Клетка с координатами верт 2 гориз 3
            if (isO(map[i - 1][j]) || isO(map[i + 1][j]) || isO(map[i][j - 1])){
                isTrue = true;
                return isTrue;
            }

        } else if(i == SIZE - 1 && j == 0){//Клетка с координатами верт 3 гориз 1
            if (isO(map[i - 1][j]) || isO(map[i - 1][j + 1]) || isO(map[i][j + 1])){
                isTrue = true;
                return isTrue;
            }

        } else if(i == SIZE - 1 && j != 0 && j != SIZE - 1){//Клетка с координатами верт 3 гориз 2
            if (isO(map[i][j -1]) || isO(map[i - 1][j]) || isO(map[i][j + 1])){
                isTrue = true;
                return isTrue;
            }

        } else if(i == SIZE - 1 && j == SIZE - 1){//Клетка с координатами верт 3 гориз 3
            if (isO(map[i][j - 1]) || isO(map[i - 1][j - 1]) || isO(map[i - 1][j])){
                isTrue = true;
                return isTrue;
            }

        }
        return isTrue;
    }


    /**
     * Метод определяет занята-ли ячейка поля
     * @param a - передаем ячейку массива
     * @return - true - если ячейка пуста, false - если ячейка занята
     */
    private static boolean isEmpty(char a){
        boolean isTrue = false;

        isTrue = (a == DOT_EMPTY) ? true : false;

        return isTrue;
    }


    /**
     * Метод определяет равна-ли ячейка 'o'
     * @param a - передаем ячейку массива
     * @return - true - если ячейка 'o', false - если ячейка не 'o'
     */
    private static boolean isO(char a){
        boolean isTrue;

        isTrue = (a == DOT_O) ? true : false;

        return isTrue;
    }


    /**
     * Метод валидации запрашиваеой ячейки на корректность
     * @param x - координата по горизонтали;
     * @param y - координата по вертикали;
     * @return boolean isTrue - признак валидности;
     */
    private static boolean isCellValid(int x, int y){
        boolean isTrue = true;

        if (x >= SIZE || y >= SIZE || x < 0 || y < 0) {
            System.err.println("Таких координат нет");
            isTrue = false;
        } else if (!isEmpty(map[y][x])){
//            System.err.println("Ячейка уже занята");
            isTrue = false;
        }

        return isTrue;
    }


    /**
     * Проверяем закончена-ли игра (по заполнености массива и по выиграшным комбинациям
     * @param playerSymbol - символ текущего игрока
     * @return
     */
    private static boolean isEndGame(char playerSymbol){
        boolean isTrue = false;
        printMap();

        if (checkWin(playerSymbol)){
            System.out.println("Победили символы: " + playerSymbol);
            isTrue = true;
        }
        if (isMapFull()){ // Проверка, заполнено-ли поле
            System.out.println("Ничья");
            isTrue = true;
        }
        return isTrue;
    }


    /**
     * Проверка на заполненность поля
     * @return заполнено или нет
     */
    private static boolean isMapFull(){
        boolean isTrue = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY){
                    isTrue = false;//клетка найдена
                    break;//выход из внутреннего цикла
                }
                if (!isTrue)
                    break;//выход из внешнего цикла
            }
        }
        return isTrue;
    }


    /**
     * Проверка победных комбинаций
     * @param playerSymbol
     * @return есть-ли победные комбинации
     */
    private static boolean checkWin(char playerSymbol){
        boolean isTrue = false;
        if (checkWinDiagonal(playerSymbol) || checkWinLine(playerSymbol)){
            isTrue = true;
        }
        return isTrue;
    }


    /**
     * Метод проверит выигрышы на диагонялях
     * @param playerSymbol
     * @return
     */
    private static boolean checkWinDiagonal(char playerSymbol){
        boolean isTrue = false;
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == playerSymbol){
                    countLeft++;
                }
                if (map[i][SIZE - i - 1] == playerSymbol){
                    countRight++;
                }
        }
        if (countLeft == SIZE || countRight == SIZE){
            isTrue = true;
        }
        return isTrue;
    }


    /**
     * Метод проверит выигрышы на горизонтальных и вертикальных линиях
     * @param playerSymbol
     * @return
     */
    private static boolean checkWinLine(char playerSymbol){
        boolean isTrue = false;
        int countHorizont = 0;
        int countVertical = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == playerSymbol){
                    countHorizont++;
                }
                if (map[j][i] == playerSymbol){
                    countVertical++;
                }
            }
            if (countHorizont == SIZE || countVertical == SIZE){
                isTrue = true;
                break;
            }
            countHorizont = 0;
            countVertical = 0;
        }
        return isTrue;
    }


}
