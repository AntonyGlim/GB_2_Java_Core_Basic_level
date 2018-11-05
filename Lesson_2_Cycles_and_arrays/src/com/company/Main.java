//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
//  заполнить его диагональные элементы единицами;
//5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true
//  если в массиве есть место, в котором сумма левой и правой части массива равны.
//  Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
//  checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
//7.*Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
//  при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.



//ВАЖНО! Почти все массивы в программе генерируются случайным образом,
// поэтому, если вы хотите проверить условие еще раз - перезапустите
// пограмму. Будут сгенерированы другие массивы.

package com.company;

public class Main {

    public static void main(String[] args) {
    //Задание 1
        System.out.println("Задание №1");
        int[] arr = new int[10]; //Зададим только длину массива
        arr = createArr(arr, 2); //Сгенерируем массив автоматически
        System.out.println("Исходный массив: ");
        Util.printArr(arr); //Метод выведет 1-о мерный массив в консоль
        changeArrVal(arr);//Меняем все 0 на 1 и наоборот
        System.out.println("Переработанный массив: ");
        Util.printArr(arr); //Выводим массив еще раз
        System.out.println();

    //Задание 2
        System.out.println("Задание №2");
        int[] arr_2 = new int[8]; //Зададим только длину массива
        for (int i = 0; i < arr_2.length; i++){
            arr_2[i] = i * 3;
        }
        Util.printArr(arr_2); //Выводим массив
        System.out.println();

    //Задание 3
        System.out.println("Задание №3");
        int[] arr_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: ");
        Util.printArr(arr_3); //Выводим массив изначальный
        for (int i = 0; i < arr_3.length; i++){
            arr_3[i] = (arr_3[i] < 6) ? (arr_3[i] *= 2) : arr_3[i];
        }
        System.out.println("Переработанный массив: ");
        Util.printArr(arr_3); //Выводим массив уже переработанный
        System.out.println();

    //Задание 4
        System.out.println("Задание №4");
        int[][] arr_4 = new int[10][10];
        System.out.println("Исходный массив: ");
        Util.printArr(arr_4); //Выводим массив изначальный
        for (int i = 0; i < arr_4.length; i++){
            arr_4[i][i] = 1;
            arr_4[i][((arr_4.length - 1) - i)] = 1;
        }
        System.out.println("Переработанный массив: ");
        Util.printArr(arr_4); //Выводим массив уже переработанный
        System.out.println();

    //Задание 5
        System.out.println("Задание №5");
        int[] arr_5 = new int[30]; //Зададим только длину массива
        arr_5 = createArr(arr_5, 100); //Сгенерируем массив автоматически
        Util.printArr(arr_5); //Метод выведет 1-о мерный массив в консоль
        System.out.println("Максимальный элемент массива: " + maxInArr(arr_5));
        System.out.println("Минимальный элемент массива: " + minInArr(arr_5));
        System.out.println();

    //Задание 6
        System.out.println("Задание №6");
        int[] arr_6 = new int[9]; //Зададим только длину массива
        arr_6 = createArr(arr_6, 3);
        Util.printArr(arr_6); //Метод выведет 1-о мерный массив в консоль
        System.out.println("Есть-ли в массиве место, в котором сумма элементов левой части,\n" +
                            "равна сумме элементов правой части? Ответ: " + checkBalance(arr_6));
        System.out.println();

    //Задание 7
        System.out.println("Задание №7");
        int n = -5; //Задаем число, на которое хотим сдвинуть
        int[] arr_7 = new int[20];
        arr_7 = createArr(arr_7, 100);
        System.out.println("Исходный массив: ");
        Util.printArr(arr_7);
        shiftArrToN(arr_7, n); //Метод сдвинет все элементы на n вправо или влево
        System.out.println("Массив после сдвига на: " + n);
        Util.printArr(arr_7);
    }


//    ПОЧЕМУ-ТО НЕ СРАБОТАЛО
//    public static int[] createArr (int[] arr){//Сгенерируем массив автоматически
//        for (int i : arr){
//            i = (int)(Math.random()*100) % 2;
//            System.out.println(i);
//        }
//        return arr;
//    }



    public static int[] createArr (int[] arr, int maxElement){//Сгенерируем массив автоматически maxElement = (максимальное значение элемента в массиве +1)
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*maxElement);//нам даже не нужен остаток от деления, т.к. приводя число к int мы просто отбрасываем то, что за запятой, и не округляем а получить мы можем числа от 0 до 1,99999999
        }
        return arr;
    }







    public static int[] changeArrVal (int[] arr){//Меняем в массиве все 0 на 1 и наоборот
        for (int i = 0; i < arr.length; i++){
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }



    public static int maxInArr(int[] arr){ //Максимальный элемент в массиве
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = (arr[i] > max) ? arr[i] : max;

        return max;
    }



    public static int minInArr(int[] arr){//Минимальный элемент в массиве
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
            min = (arr[i] < min) ? arr[i] : min;

        return min;
    }



    public static boolean checkBalance(int[] arr){//Метод определяет есть-ли в массиве место, в котором сумма элементов левой части, равна сумме элементов правой части?
        boolean isTrue = false;
        int indexFromStart = 0; //индекс элементов начиная с начала массива
        int indexFromEnd = arr.length - 1; //индекс элементов начиная с конца массива
        if (indexFromStart == indexFromEnd) //защищаемся от массива состоящего из 1 элемента
            return isTrue;
        int summStart = arr[indexFromStart];
        int summEnd = arr[indexFromEnd];

        while ((indexFromEnd - indexFromStart) > 1){// пока сумма с конца не "встретилась" с суммой с начала
                if (summStart <= summEnd) {//если одна из сумм меньше, то увеличиваем в первую очередь ее, и снова проверяем
                indexFromStart++;
                summStart += arr[indexFromStart];
            } else if (summStart > summEnd) {
                indexFromEnd--;
                summEnd += arr[indexFromEnd];
            }
        }
        if (summStart == summEnd){//если после работы цикла суммы равны - возвращаем true
            System.out.println("Граница проходит между " + indexFromStart + " и " + indexFromEnd + " элементом");
            System.out.println();
            isTrue = true;
        }
        return isTrue;
    }



    public static int[] shiftArrToOne(int[] arr){//метод сдвинет все элементы массива на 1 позицию вправа
        int b;
        for (int i = 0; i < arr.length; i++){
            int nextIndex = (i + 1) % arr.length;
            b = arr[nextIndex];
            arr[nextIndex] = arr[0];
            arr[0] = b;
        }
        return arr;
    }



    public static int[] deShiftArrToOne(int[] arr){//метод сдвинет все элементы массива на 1 позицию влево
        int b;
        for (int i = arr.length -1; i > 0; i--){
            int lastIndex = (Math.abs(i - 1) % arr.length);
            b = arr[lastIndex];
            arr[lastIndex] = arr[arr.length -1];
            arr[arr.length -1] = b;
        }
        return arr;
    }



    public static int[] shiftArrToN(int[] arr, int n){//Метод сдвинет все элементы массива на число n. Если это +n - сдвиг вправо, если это -n - сдвиг влево. Если n=0 - вернет изначальный массив.

        for (int i = 0; i < Math.abs(n); i++){
            if (n > 0){
                shiftArrToOne(arr);
            } else if (n < 0){
                deShiftArrToOne(arr);
            } else if (n == 0){
                return arr;
            }
        }
        return arr;
    }

} //END
