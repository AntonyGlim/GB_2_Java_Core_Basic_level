//5.2 Кот должен есть из миски. Создайте такую сущность,
// которая будет обладать объёмом и едой в ней,
// а также методами наполнения и получения информации о количестве еды;

public class Bowl {

    private int volumeOfBowl = 500;                  // Oбъем миски по умолчанию
    private int amountOfFoodInBowl = 0;             // Количество еды в миске по умолчанию


    /**
     * Конструктор создаст экземпляр класса Миска
     * @param volumeOfBowl - Oбъем миски заданный пользователем
     * @param amountOfFoodInBowl - Количество еды в миске заданное пользователем
     */
    public Bowl(int volumeOfBowl, int amountOfFoodInBowl){
        if (volumeOfBowl > 0 && amountOfFoodInBowl > 0 && amountOfFoodInBowl <= volumeOfBowl){
            this.volumeOfBowl = volumeOfBowl;
            this.amountOfFoodInBowl = amountOfFoodInBowl;
            System.out.println("Миска вмещает " + volumeOfBowl + " грамм, сейчас в ней: " + amountOfFoodInBowl + " грамм.");
        } else {
            System.out.println("Не допустимый объем миски или количества еды в миске!");
            System.out.println("Создана миска по умолчанию");
            System.out.println("Миска вмещает " + this.volumeOfBowl + " грамм, сейчас в ней: " + this.amountOfFoodInBowl + " грамм.");
        }
    }


    /**
     * Метод наполнения миски едой
     * @param amountOfFoodWantToFill - количество еды, которое вы хотите положить в миску
     * В миске не может поместиться больше, чем ее объем, если мы сыпем больше, в миске все равно останется количесто
     * еды, равное ее объему
     */
    void fillABowlWithFood(int amountOfFoodWantToFill){
        if (amountOfFoodWantToFill > 0) {
            amountOfFoodInBowl = (amountOfFoodWantToFill >= (volumeOfBowl - amountOfFoodInBowl)) ? volumeOfBowl : (amountOfFoodInBowl + amountOfFoodWantToFill);
            System.out.println("Мы насыпаем в миску - " + amountOfFoodWantToFill + " грамм еды");
            System.out.println("В миске сейчас находится " + amountOfFoodInBowl + " грамм еды");
        } else {
            System.out.println("Вы хотите положить не допустимый объем еды!");
        }
    }


    public int getAmountOfFoodInBowl() {
        return amountOfFoodInBowl;
    }


    public void setAmountOfFoodInBowl(int amountOfFoodInBowl) {
        this.amountOfFoodInBowl = amountOfFoodInBowl;
    }


}
