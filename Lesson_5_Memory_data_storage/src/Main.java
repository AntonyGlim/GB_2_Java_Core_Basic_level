public class Main {
    public static void main(String[] args) {

        //5.3 Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е.,
        //конкретный кот ест из конкретной миски, уменьшая объём еды в ней;

        //5.6 Создать массив котов и одну тарелку с едой,
        // попросить всех котов покушать из этой тарелки
        // и потом вывести информацию о сытости котов в консоль;

        Cat[] cats = { //Создаем массив котов
                new Cat("Барсик", -10),
                new Cat("Рыжий", 70),
                new Cat("Мурлыка", 150),
                new Cat("Котофей", 40),
                new Cat("Черныш", 450),
        };

        Bowl bowl = new Bowl(0, 400);// Создаем экземпляр класса Миска
        System.out.println();

        for (Cat c : cats){ //каждый кот будет есть из миски
            bowl.setAmountOfFoodInBowl(c.animalEatFromBowl(bowl.getAmountOfFoodInBowl()));// Кот съел из миски сколько смог и наелся но в миске еще осталось или закончилось
            if (bowl.getAmountOfFoodInBowl() == 0){//Если кот не наелся
                while (!c.isSatiety()) {// досыпаем, пока кот не наестся
                    bowl.fillABowlWithFood(100);// 5.7 Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
                    bowl.setAmountOfFoodInBowl(c.animalEatFromBowl(bowl.getAmountOfFoodInBowl()));//ПРОЩЕ РАБОТАТЬ ТАК: cat.eatFood(Bowl bowl);
                }
            }
            System.out.println();
        }

        System.out.println("Все коты наелись досыта, но давайте еще раз попросим каждого подойти к миске!");
        bowl.fillABowlWithFood(800);//Наполним миску до краев
        System.out.println();

        for (Cat c : cats) { //каждый кот будет есть из миски еще раз
            bowl.setAmountOfFoodInBowl(c.animalEatFromBowl(bowl.getAmountOfFoodInBowl()));
            System.out.println();
        }

        /*
        for (Cat c : cats) { //Проверка значения аппетита у кота для отладки
            System.out.println(c.name + " сыт, но аппетит его все так же:  " + c.getAppetite());
        }
        */
    }
}
