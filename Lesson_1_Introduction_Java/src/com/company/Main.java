//Создать пустой проект в IntelliJ IDEA и прописать метод main();
//Создать переменные всех пройденных типов данных, и инициализировать их значения;
//Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
//Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
//Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
//Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
//Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
//*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
//*Не набирая код в IDE, ответьте на следующий вопрос. Есть два метода
//void myMethod(int a, String b) {}
//void myMethod(String b, int a) {}
//
//Это две разных сигнатуры метода или один и тот же метод?
//ОТВЕТ: ЭТО 2 РАЗНЫХ МЕТОДА. Т.К. ОНИ ПРИНИМАЮТ РАЗЛИЧНЫЕ АРГУМЕНТЫ.

package com.company;

public class Main {
//Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        //Создать переменные всех пройденных типов данных, и инициализировать их значения;
        System.out.println("example 1");
        example_1();
        System.out.println("");

        //Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        // где a, b, c, d – входные параметры этого метода;
        System.out.println("example 2");
        System.out.println(example_2(1, 2,3,0));
        System.out.println("");

        //Написать метод, принимающий на вход два числа, и проверяющий,
        // что их сумма лежит в пределах от 10 до 20 (включительно),
        // если да – вернуть true, в противном случае – false;
        System.out.println("example 3");
        System.out.println(example_3(10, 1));
        System.out.println("");

        //Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное число передали или отрицательное
        // (Замечание: ноль считаем положительным числом.);
        System.out.println("example 4");
        System.out.println(example_4(0));
        System.out.println("");

        //Написать метод, которому в качестве параметра передается целое число,
        // метод должен вернуть true, если число отрицательное;
        System.out.println("example 5");
        System.out.println(example_5(12));
        System.out.println("");

        //Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        System.out.println("example 6");
        example_6("Федя");
        System.out.println("");

        //*Написать метод, который определяет, является ли год високосным,
        // и выводит сообщение в консоль. Каждый 4-й год является високосным,
        // кроме каждого 100-го, при этом каждый 400-й – високосный.
        System.out.println("example 7");
        example_7(400);
    }

    static void example_1 () {
        byte b = 127;
        short s = 45;
        int a = 125;
        long l = 5248L;
        float f = 4568.56f;
        double d = 457868.5696d;
        char ch = 'C';
        boolean bul = true;

        System.out.println(b);
        System.out.println(s);
        System.out.println(a);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(ch);
        System.out.println(bul);
    }

    static float example_2 (int a, int b, int c, int d){
        float result;
        if (d != 0)
            result = (a * (b + (c / d)));
        else {
            System.err.println("Нельзя делить на ноль");
            result = 0;
        }
        return result; //Правила хорошего кода - 1 return
    }

    static double example_2 (double a, double b, double c, double d){
        return (a * (b + (c / d)));
    }

    static boolean example_3(int a, int b){
        if ((a + b) >= 10 && (a + b) <= 20)
            return true;
        else
            return false;
    }

    static String example_4(int a){
        return (a >= 0) ? "Положительное" : "Отрицательное";
    }

    static boolean example_5(int a) {
        return (a < 0);
    }

    static void example_6(String str){
        System.out.println("Привет, " + str + "!");
    }

    static boolean example_7(int year){
        return  (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }


}
