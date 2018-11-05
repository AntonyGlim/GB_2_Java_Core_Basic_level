//6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//  В качестве параметра каждому методу передается величина, означающая или длину препятствия
// (для бега и плавания), или высоту (для прыжков);

import java.util.Random;

public abstract class Animal {
    public String name;


    protected float distanceRunLimit = 0f;
    protected float distanceSwimLimit = 0f;
    protected float heightJumpLimit = 0f;

    protected float randomDistanceRunLimit = 0f;
    protected float randomDistanceSwimLimit = 0f;
    protected float randomHeightJumpLimit = 0f;

    String runStr = "бежать";
    String swimStr = "плыть";
    String jumpOverStr = "подпрыгнуть";

    public Animal(){
        this.name = "Безымянный";
    }
    public Animal(String name){
        this.name = name;
    }

    // Метод вывода информации в консоль. Общий для всех подклассов
    public void render(float distance, float distanceLimit, String motion){
        boolean isTrue = false;
        if (distance <= distanceLimit && distanceLimit != 0) {
            isTrue = true;
            System.out.println("Животное сможет " + motion + " на " + distance + " метров! - " + isTrue);
        } else
            System.out.println("Животное не сможет " + motion + " на " + distance + " метров! - " + isTrue);
    }

    // Метод генерации случайного лимита для животных
    public int randomValue(float distanceLimit){
        int randomNumber = (int)(distanceLimit/2 + Math.random()*distanceLimit + Math.random()*10);
        return randomNumber;
    }

    public void run(float distance){
        render(distance, randomDistanceRunLimit, runStr);
        System.out.println("Максимальный предел: " + randomDistanceRunLimit + " м.");
    }

    public void swim(float distance){
        render(distance, randomDistanceSwimLimit, swimStr);
        System.out.println("Максимальный предел: " + randomDistanceSwimLimit + " м.");
    }

    public void jumpOver(float distance){
        render(distance, randomHeightJumpLimit, jumpOverStr);
        System.out.println("Максимальный предел: " + randomHeightJumpLimit + " м.");
    }

}