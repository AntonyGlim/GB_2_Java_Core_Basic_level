/*
1. Разработать оконное приложение «Калькулятор»;
1.1. Калькулятор должен выполнять 4 простейшие арифметические операции.
1.2. Калькулятор должен иметь одно окно вывода результатов.
1.3. Калькулятор работает с двумя параметрами, вводимыми пользователем в окна ввода.

Подсказка 1: поля ввода в приложении дают читать только текстовые данные. Для преобразования
нужно использовать классы-оболочки: https://habrahabr.ru/post/49582/.

Подсказка 2: можно сделать код гораздо проще, изучив возможности ActionEvent:
https://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener.

2. *Научить калькулятор операции возведения в степень.
 */


/**
 * Программа выполняет 5 простых действий над числами типа float
 * Мне не совсем понятно что имеется в виду под одни окном вывода результатов.
 * В этой программе результаты демонстрируются в MessageDialog. Одно окно тоже сделать не трудно, например добавив 3-е поле JTextField и помещая туда результат
 */

import javax.naming.NameNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

public class Calculator extends JFrame {

    public static float a;                                                                                 //Первая из переменных они должны быть доступны из любого места программы
    public static float b;                                                                                 //Вторая из переменных они должны быть доступны из любого места программы
    public static float result;                                                                            //Результат. Все имеет тип float для точных вычислений

    public static JTextField textFieldA = new JTextField(29);                                      //Поля тоже должны быть доступны отовсюду
    public static JTextField textFieldB = new JTextField(29);                                      //Поля тоже должны быть доступны отовсюду
    public static JTextField textFieldResult = new JTextField(29);                                 //Поля тоже должны быть доступны отовсюду


    public static JFrame calculatorFrame = new JFrame("Программа \"Простой калькулятор\"");           //Окно с заголовком


    public static void main(String[] args) {

// Графическая часть программы

        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setPreferredSize(new Dimension(340, 210));                           //Устанавливаем размер

        JPanel generalContents = new JPanel(new VerticalLayout());                                         //Создаем главный контейнер, куда сложим все компоненты и другие контейнеры. VerticalLayout переписан в соответстыующем классе

        generalContents.add(new JLabel("Используя точку для дробных чисел, ведите число a: "));       //Сообщение "Введите число a: "
        generalContents.add(textFieldA);                                                                   //Поле для ввода a

        generalContents.add(new JLabel("Используя точку для дробных чисел, ведите число b: "));       //Сообщение "Введите число b: "
        generalContents.add(textFieldB);                                                                   //Поле для ввода b

        JPanel boxContents = new JPanel();
        boxContents.setLayout(new BoxLayout(boxContents, BoxLayout.X_AXIS));                               //Создаем вспомогательный контейнер, куда сложим все кнопки
        boxContents.add(Box.createHorizontalStrut(2));                                              //Добавляем разделитель

        createButtonWithAction("a + b", boxContents);                                          //Метод создает кнопку с названием и разделитель и добавляет их в контейнер
        createButtonWithAction("a - b", boxContents);
        createButtonWithAction("a x b", boxContents);
        createButtonWithAction("a / b", boxContents);
        createButtonWithAction("a ^ b", boxContents);

        generalContents.add(boxContents);                                                                 //Добавляем в главный контейнер контейнер с кнопками

        generalContents.add(new JLabel("Результат: "));                                              //Сообщение "Результат: "
        generalContents.add(textFieldResult);                                                             //Поле для вывода result

        calculatorFrame.setContentPane(generalContents);                                                  //Ставим панель содержимого окна
        centerFrame(calculatorFrame);                                                                     //Выравниваем по центру экрана
        calculatorFrame.pack();                                                                           //Упаковываем все
        calculatorFrame.setResizable(false);                                                              //Запрещаем изменять размеры окна
        calculatorFrame.setVisible(true);                                                                 //Выводим на экран
    }


    /**
     * Метод создает кнопку, добавляет ее в панель и описывает ее поведение в зависимости от названия кнопки
     * @param buttonName - то как мы хотим кнопку назвать
     * @param panel - та панель в которую мы хотим добавить кнопку
     */
    public static void createButtonWithAction(String buttonName, JPanel panel){

        JButton but = new JButton(buttonName);                                                             //Создаем кнопку
        panel.add(but);                                                                                    //Добавляем ее на панель
        panel.add(Box.createHorizontalStrut(5));                                                    //Добавляем разделитель

        but.addActionListener(new ActionListener() {                                                       //Добавляем слушателя
            @Override
            public void actionPerformed(ActionEvent e) {
                try {                                                                                      //Введенное пользователем должно быть именно числом, а не простым текстом. Проверяем это
                    if (textFieldA.getText().trim().length() > 0 &&
                        textFieldB.getText().trim().length() > 0) {                                        //Проверка на заполненность текстовых полей и в первом и во втором поле должны быть значения

                        a = Float.parseFloat(textFieldA.getText());                                        //Преобразовываем String во float
                        b = Float.parseFloat(textFieldB.getText());
                        boolean isCorrect = true;                                                          //Для проверки на корректность введенных значений

                        if (but.getText().equals("a + b")){
                            result = a + b;
                        }
                        if (but.getText().equals("a - b")){
                            result = a - b;
                        }
                        if (but.getText().equals("a x b")){
                            result = a * b;
                        }
                        if (but.getText().equals("a / b"))
                            if (b != 0) {
                                result = a / b;                                                                         //На ноль, традицыонно делить нельзя (проверяем это)
                            }
                            else {
//                                System.out.println("Данные не корректны");
//                                JOptionPane.showMessageDialog(null, "Данные не корректны");
                                textFieldResult.setText("Данные не корректны");                                         //Устанавливаем в соответствующее поле результат
                                isCorrect = false;                                                                      //Введенные значения не корректны
                            }
                        if (but.getText().equals("a ^ b")){
                            result = (float) Math.pow(a, b);                                                            //Возводим в степень стандартной функцией из пакета Math
                        }
                        if (isCorrect) {
//                            System.out.println(result);                                                                 //Выводим в консоль для информации отладки
//                            JOptionPane.showMessageDialog(null, "Результат вычислений: \n" + result);
                            textFieldResult.setText("" + result);                                                       //Устанавливаем в соответствующее поле результат
                        }
                    } else {
//                        System.out.println("Должны быть введены оба числа");                                            //Выводим в консоль для информации отладки
//                        JOptionPane.showMessageDialog(null, "Должны быть введены оба числа");
                        textFieldResult.setText("Должны быть введены оба числа");                                       //Устанавливаем в соответствующее поле результат
                    }
                } catch (NumberFormatException ex) {
//                    System.out.println("Значение должно быть числом");                                                  //Выводим в консоль для информации отладки
//                    JOptionPane.showMessageDialog(null, "Значение должно быть числом");
                    textFieldResult.setText("Значение должно быть числом");                                             //Устанавливаем в соответствующее поле результат
                }
            }
        });
    }


    /**
     * Установка окна в центре экрана
     *(почему-то не возвращаются значения getWidth() и getHeight() для JFrame, но разбираться уже нет времени)
     *
     */
    public static void centerFrame(JFrame frame) {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        int x = (int) ((screenSize.getWidth() - 340) / 2);
        if (x < 0) {
            x = 0;
        }
        int y = (int) ((screenSize.getHeight() - 230) /2);
        if (y < 0) {
            y = 0;
        }
        frame.setBounds(x, y, 0, 0);
    }

}
