import java.util.logging.SocketHandler;

//1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
public class Employee {
    protected String name;
    protected String position;
    protected String email;
    protected String phone;
    protected int salary;
    protected int age;

//2. Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
//3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void employeeInfo(){
        System.out.println("Имя сотрудника: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Email сотрудника: " + email);
        System.out.println("Телефон сотрудника: " + phone);
        System.out.println("Зароботная плата сотрудника: " + salary + "р.");
        System.out.println("Возраст сотрудника: " + age + " лет");
    }

    public int getAge() {
        return age;
    }
}
