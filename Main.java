import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1 : ");
        /*Написать метод, который меняет два элемента массива местами (массив может быть любого
        ссылочного типа);*/
    Object[] arrayObjects1 = {1, "string", 5, 6};
    ArrayMethod<Object> arrayMethod = new ArrayMethod<>();
    try {
        System.out.println("Поменяем местами объекта массива № 2 с № 3 : " + Arrays.toString(arrayMethod.changeArrayIndex(arrayObjects1,1,3)));
    } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
    }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Задание №2 : ");
        Box<Apple> appleBox = new Box<Apple>(1f);
        Box<Orange> orangeBox = new Box<Orange>(1.5f);
        Box<Apple> appleBox2 = new Box<Apple>(1f);

        for (int i =0; i < 3; i++) {
            appleBox.addFruits(new Apple());
            orangeBox.addFruits(new Orange());
            appleBox2.addFruits(new Apple());
        }

        System.out.println("Выведем вес коробки с яблоками : " + appleBox.getBoxWeight());
        System.out.println("Выведем вес коробки с апельсинами : " + orangeBox.getBoxWeight());
        System.out.println("Выведем вес коробки #2 с яблоками : " + appleBox2.getBoxWeight());

        // сравним вес коробки с яблоками и коробки с апельсинами
        System.out.println("равна ли коробка #1 с яблоками коробке с апельсинами ? - " + appleBox.compareBoxes(orangeBox));

        //пересыпем из коробки №2 в коробку №1 с яблоками
        appleBox.shareFruits(appleBox2);
        System.out.println("Выведем вес коробки #2 после пересыпки : " + appleBox2.getBoxWeight());
        System.out.println("Выведем вес коробки #1 с яблоками после пересыпки : " + appleBox.getBoxWeight());

        //попытка пересыпать апельсины в яблоки
        //appleBox.shareFruits(orangeBox); - ошибка компилятора




    }
}
