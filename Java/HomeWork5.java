/**
* Java 1. Homework 5
*
* @author Ruslan Zhamabayev
* @version 30/01/22
*/

class HomeWork5 {

    public static void main (String[] args) {
        Employee[] employees = {
            new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30), 
            new Employee("Dimkin Dmitriy", "Florist","dmitriyflorist@gmail.com", "89251322454", 50000, 45), 
            new Employee("Anatoliy Anatolievich", "Inspector","ainspect@gmail.com", "99251324242", 65000, 50),
            new Employee("Petr Petrovich", "Writer","writepetr@gmail.com", "89997213232", 100000, 35),
            new Employee("Vasiliy Ivanovich", "Fireman","firevasya@gmail.com", "89990010101", 35000, 43),
        };

        for(Employee employee : employees) {
            if (employee.getAge () > 40) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String firstAndLastName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String firstAndLastName, String position, String email, String phone, int salary, int age) {
        this.firstAndLastName = firstAndLastName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return("First name: " + firstAndLastName + 
            "\n| Position: " + position + 
            "\n| Email: " + email + 
            "\n| Phone: " + phone + 
            "\n| Salary: " + salary + 
            "\n| Age: " + age);
    }
}