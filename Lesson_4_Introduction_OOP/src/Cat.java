//5. Создать классы Собака и Кот с наследованием от класса Животное;

//7. У каждого животного есть ограничения на действия
//(бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
//плавание: кот не умеет плавать, собака – 10 м.);

public class Cat extends Animal{
    public Cat(String name){
        super("Кот " + name);
        this.distanceRunLimit = 200;
        this.distanceSwimLimit = 0;
        this.heightJumpLimit = 2;

        randomDistanceRunLimit = randomValue(distanceRunLimit);
        randomDistanceSwimLimit = randomValue(distanceSwimLimit);
        randomHeightJumpLimit = randomValue(heightJumpLimit);
    }
}
