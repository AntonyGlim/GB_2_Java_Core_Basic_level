//5. Создать классы Собака и Кот с наследованием от класса Животное;

//7. У каждого животного есть ограничения на действия
//(бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
//плавание: кот не умеет плавать, собака – 10 м.);

public class Cat extends Animal{

    // 5.1 Класс кота из прошлого ДЗ расширить функционалом потребления пищи.
    // У каждого кота есть апетит, т.е. количество еды, которое он съедает за один раз;

    private int appetite = 50;// Аппетит кота по умолчанию
    int appetiteChange;//Изменение аппетита

    // 5.5 Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    // Если коту удалось поесть (хватило еды), сытость = true;
    // Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
    // то есть не может быть наполовину сыт (это сделано для упрощения логики программы);
    // НЕ СЧИТАЕМ ТАК. РЕАЛИЗУЕМ ЛОГИКУ, В КОТОРОЙ КОТ МОЖЕТ СЪЕСТЬ ЧАСТЬ И НЕ НАЕСТСЯ
    // (ТОГДА ОН СЧИТАЕТСЯ ГОЛОДНЫМ, НО ЕГО ИЗМЕНЕНИЕ АППЕТИТА МЕНЯЕТСЯ)

    private boolean satiety = false; //Сытость - изначально голодный

    public Cat(String name, int appetite){
        super("Кот " + name);
        if (appetite <= 0) {
            System.out.println("Введено не корректное значение аппетита");
            System.out.println("Аппетит " + name + " будет иметь по умолчанию - " + this.appetite +  " грамм еды");
            System.out.println();
            appetiteChange = this.appetite;
        } else {
            this.appetite = appetite;
            appetiteChange = appetite;
        }
    }


    /**
     * Метод описывает как животное ест из миски
     * @param amountOfFoodInBowl - количество еды в миске
     * @return - возвращает измененное количество оставшейся еды
     * В методе работаем с изменениям в аппетите, а не с самим аппетитом, для того
     * чтобы сохранить значение изначального аппетита
     */
    int animalEatFromBowl(int amountOfFoodInBowl){ // НЕ ПРАВИЛЬНО РАБОТАТЬ С КОЛИЧЕСТВОМ ЕДЫ НА СТОРОНЕ КОТА. ЭТОТ МЕТОД ДОЛЖЕН БЫТЬ НА СТОРОНЕ МИСКИ
        if (!satiety) {//если голодный
            amountOfFoodInBowl = amountOfFoodInBowl - appetiteChange;
            System.out.println(name + " голодный и он начинает есть...");

            if (amountOfFoodInBowl >= 0) { //5.4 Предусмотрите проверку, при которой в миске не может получиться отрицательного количества еды (например, в миске 10 единиц еды, а кот пытается съесть 15);
                System.out.println(name + " съел " + appetiteChange + " грамм и наелся! Благодарит за угощение!");
                System.out.println("В миске осталось " + amountOfFoodInBowl + " грамм еды");
                satiety = true;
            } else {
                appetiteChange = Math.abs(amountOfFoodInBowl);
                System.out.println(name + " не наелся! Закончилась еда! Ему требуется еще " + appetiteChange + " грамм еды");
                amountOfFoodInBowl = 0; //Обнуляем значение, чтобы не "накапливать" голод)
            }
        } else {
            System.out.println(name + " не станет есть. Он уже сыт!");
        }
        return amountOfFoodInBowl;
    }


    /**
     * Метод сделает животное снова голодным
     */
    public void hungryAgain(){
        appetiteChange = appetite;
        satiety = false;
    }


    /**
     * Возвращаем значение аппетита
     * @return
     */
    public int getAppetite() {
        return appetite;
    }


    /**
     * Возвращаем голодное-ли животно
     * @return
     */
    public boolean isSatiety() {
        return satiety;
    }
}
