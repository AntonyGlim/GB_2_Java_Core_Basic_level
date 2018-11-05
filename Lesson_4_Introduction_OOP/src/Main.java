public class Main {
    public static void main(String[] args) {
        //1.
        //Employee employee = new Employee("Иван", "Директор", "f@com", "7-77-21", 100000, 45);
        //employee.employeeInfo();

        // 4. Создать массив из 5 сотрудников: Пример: Person[] persArray = new Person[5];
        // Вначале объявляем массив объектов
        // persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000, 30);
        // потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
        // С помощью цикла вывести информацию только о сотрудниках старше 40 лет;

        Employee[] employeesArray = new Employee[5];
        employeesArray[0] = new Employee("Иван Груздь", "Директор", "ig@com", "7-77-21", 100000, 45);
        employeesArray[1] = new Employee("Семен Стенко", "Помошник", "sc@com", "7-77-22", 90000, 50);
        employeesArray[2] = new Employee("Семен Карпов", "Инженер", "ck@com", "7-77-03", 50000, 41);
        employeesArray[3] = new Employee("Вадим Карпов", "Инженер", "vk@com", "7-77-09", 52000, 25);
        employeesArray[4] = new Employee("Елена Фомина", "Инженер", "ef@com", "7-77-05", 55000, 21);

        for (Employee empl : employeesArray){
            if (empl.getAge() > 40){
                empl.employeeInfo();
                System.out.println();
            }
        }


        Animal cat_1 = new Cat("Мурзик");
        System.out.println(cat_1.name + ":");
        cat_1.run(201);
        cat_1.swim(0);
        cat_1.jumpOver(1);

        System.out.println();

        Animal cat_2 = new Cat("Барсик");
        System.out.println(cat_2.name + ":");
        cat_2.run(201);
        cat_2.swim(0);
        cat_2.jumpOver(1);

        System.out.println();

        Animal dog_1 = new Dog("Шарик");
        System.out.println("Пес " + dog_1.name + ":");
        dog_1.run(600);
        dog_1.swim(2);
        dog_1.jumpOver(10);

        System.out.println();

        Animal dog_2 = new Dog("Каштанка");
        System.out.println("Пес " + dog_2.name + ":");
        dog_2.run(600);
        dog_2.swim(2);
        dog_2.jumpOver(10);
    }
}
