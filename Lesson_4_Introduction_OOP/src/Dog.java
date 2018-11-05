//5. Создать классы Собака и Кот с наследованием от класса Животное;

//7. У каждого животного есть ограничения на действия
//(бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
//плавание: кот не умеет плавать, собака – 10 м.);

public class Dog extends Animal{
    public Dog(String name){

    super("Пес " + name);
    this.distanceRunLimit = 50;
    this.distanceSwimLimit = 10;
    this.heightJumpLimit = 0.5f;

    randomDistanceRunLimit = randomValue(distanceRunLimit);
    randomDistanceSwimLimit = randomValue(distanceSwimLimit);
    randomHeightJumpLimit = randomValue(heightJumpLimit);
    }
}

