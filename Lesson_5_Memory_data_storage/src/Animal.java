//6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//  В качестве параметра каждому методу передается величина, означающая или длину препятствия
// (для бега и плавания), или высоту (для прыжков);

import java.util.Random;

public abstract class Animal {// В этой задаче он по сути не нужен. Весь функционал из прошлой задачи из него убран
    public String name;

    public Animal(){
        this.name = "Безымянный";
    }
    public Animal(String name){
        this.name = name;
    }

}