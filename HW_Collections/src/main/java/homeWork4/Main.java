package homeWork4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //создаем массив
        ArrayList <String> arr = new ArrayList<>();
        arr.add(0, "Мое");
        arr.add(1, "сердце");
        arr.add(2, "остановилось");
        arr.add(3, ",");
        arr.add(4, "мое");
        arr.add(5, "сердце");
        arr.add(6, "замерло");
        arr.add(7, ",");
        arr.add(8, "мое");
        arr.add(9, "сердце");
        arr.add(10, "асталависта");

        WordsArray wordsArray = new WordsArray(arr);
        wordsArray.checkArray();
        doPhoneBooke();

    }
    public static void doPhoneBooke(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addToPhoneBook("Petr", "87773333333");
        phoneBook.addToPhoneBook("Petr", "87774444444");
        phoneBook.addToPhoneBook("Petr", "87775555555");

        System.out.println("Задание 2 _____________________________");

        System.out.println("Petr" + phoneBook.getPhonesByName("Petr"));
    }

}

/*1 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.

2 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
Консоль использовать только для вывода результатов проверки телефонного справочника.*/