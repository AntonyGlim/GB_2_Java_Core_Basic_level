package com.company;

public class Util {

    public static void printArr (int[] arr){//Метод выведет 1-о мерный массив в консоль
        for (int i : arr){
            System.out.print(i + "\t");
        }
        System.out.println();
    }



    public static void printArr (int[][] arr){//Метод выведет 2-у мерный массив в консоль
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
